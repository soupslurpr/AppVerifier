package dev.soupslurpr.appverifier.ui

import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import dev.soupslurpr.appverifier.data.Hashes
import dev.soupslurpr.appverifier.data.InternalDatabaseInfo
import dev.soupslurpr.appverifier.data.InternalDatabaseStatus
import dev.soupslurpr.appverifier.data.SimpleVerificationStatus
import dev.soupslurpr.appverifier.data.UserDatabaseEntry
import dev.soupslurpr.appverifier.data.VerificationInfo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppListScreen(
    searchQuery: String,
    onClickAppItem: (
        name: String,
        packageName: String,
        hash: Hashes,
        icon: Drawable,
        internalDatabaseInfo: InternalDatabaseInfo,
    ) -> Unit,
    onLaunchedEffect: () -> Unit,
    onQueryChange: (query: String) -> Unit,
    onSearch: (query: String) -> Unit,
    onSearchActiveChange: (active: Boolean) -> Unit,
    getHashesFromPackageInfo: (packageInfo: PackageInfo) -> Hashes,
    getInternalDatabaseInfoFromVerificationInfo: (verification: VerificationInfo) -> InternalDatabaseInfo,
    sharedFilteredEntries: List<UserDatabaseEntry>? = null,
    onDoneFiltered: (() -> Unit)? = null,
) {
    val context = LocalContext.current

    val packageManager: PackageManager = context.packageManager

    val systemPackages = packageManager.getInstalledPackages(PackageManager.MATCH_SYSTEM_ONLY)

    val userInstalledPackages = packageManager.getInstalledPackages(0)

    userInstalledPackages.removeIf { userInstalledPackage ->
        userInstalledPackage.packageName == systemPackages.firstOrNull {
            it.packageName == userInstalledPackage.packageName
        }?.packageName
    }

    val filteredPackages = if (sharedFilteredEntries != null) {
        val filterNames = sharedFilteredEntries.map { it.packageName }.toSet()
        userInstalledPackages.filter { it.packageName in filterNames }
    } else {
        userInstalledPackages
    }

    LaunchedEffect(key1 = Unit) {
        onLaunchedEffect()
    }

    Scaffold(
        topBar = {
            val colors1 = SearchBarDefaults.colors()
            DockedSearchBar(
                inputField = {
                    SearchBarDefaults.InputField(
                        query = searchQuery,
                        onQueryChange = onQueryChange,
                        onSearch = onSearch,
                        expanded = false,
                        onExpandedChange = onSearchActiveChange,
                        placeholder = { Text(stringResource(android.R.string.search_go)) },
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                        colors = colors1.inputFieldColors,
                    )
                },
                expanded = false,
                onExpandedChange = onSearchActiveChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 8.dp),
                colors = colors1
            ) {}
        }
    ) { innerPadding ->
        LazyColumn(
            Modifier.padding(
                innerPadding.calculateStartPadding(LayoutDirection.Ltr),
                innerPadding.calculateTopPadding(),
                innerPadding.calculateEndPadding(LayoutDirection.Ltr)
            )
        ) {
            if (sharedFilteredEntries != null) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            "Showing ${filteredPackages.size} installed of ${sharedFilteredEntries.size} total",
                            style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                        )
                        androidx.compose.material3.TextButton(onClick = { onDoneFiltered?.invoke() }) {
                            Text("Done")
                        }
                    }
                }
            }
            if (filteredPackages.isEmpty() && sharedFilteredEntries != null) {
                item {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            "No installed apps match the shared package names.",
                            modifier = Modifier.padding(32.dp),
                            style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
                        )
                    }
                }
            }
            items(filteredPackages) {
                // Do not show AppVerifier in the list as there is no point in using it to verify itself.
                if (it.packageName == context.packageName) return@items

                val packageInfo = packageManager.getPackageInfo(
                    it.packageName,
                    PackageManager.GET_SIGNING_CERTIFICATES
                )
                val name = packageInfo.applicationInfo?.let { it1 ->
                    packageManager.getApplicationLabel(it1)
                        .toString()
                } ?: null.toString()

                if (searchQuery == "" || name.contains(searchQuery, true) ||
                    it.packageName.contains(searchQuery, true))
                {
                    val hashes = getHashesFromPackageInfo(packageInfo)

                    val verificationInfo = VerificationInfo(packageInfo.packageName, hashes)
                    val internalDbInfo = getInternalDatabaseInfoFromVerificationInfo(verificationInfo)

                    val sharedEntry = sharedFilteredEntries?.find {
                        it.packageName == packageInfo.packageName
                    }
                    val sharedHashMatch = if (sharedEntry != null && sharedEntry.hashes.isNotEmpty()) {
                        if (hashes.hasMultipleSigners) {
                            sharedEntry.hashes == hashes.hashes
                        } else {
                            hashes.hashes.last() in sharedEntry.hashes
                        }
                    } else {
                        null
                    }

                    AppItem(
                        name = name,
                        packageName = packageInfo.packageName,
                        hashes = hashes,
                        icon = packageManager.getApplicationIcon(
                            packageInfo.applicationInfo ?: ApplicationInfo()
                        ),
                        onClickAppItem = onClickAppItem,
                        internalDatabaseInfo = internalDbInfo,
                        internalDbStatus = internalDbInfo.internalDatabaseStatus,
                        sharedHashMatch = sharedHashMatch,
                    )
                }
            }
            item {
                Spacer(Modifier.padding(WindowInsets.navigationBars.asPaddingValues()))
            }
        }
    }
}

@Composable
fun AppItem(
    name: String,
    packageName: String,
    hashes: Hashes,
    icon: Drawable,
    onClickAppItem: (
        name: String,
        packageName: String,
        hash: Hashes,
        icon: Drawable,
        internalDatabaseInfo: InternalDatabaseInfo
    ) -> Unit,
    internalDatabaseInfo: InternalDatabaseInfo,
    internalDbStatus: InternalDatabaseStatus = InternalDatabaseStatus.NOT_FOUND,
    sharedHashMatch: Boolean? = null,
) {
    ListItem(
        modifier = Modifier.clickable {
            onClickAppItem(name, packageName, hashes, icon, internalDatabaseInfo)
        },
        headlineContent = {
            Text(name)
        },
        overlineContent = {
            Text(packageName)
        },
        leadingContent = {
            Image(
                rememberDrawablePainter(drawable = icon),
                null,
                Modifier.size(50.dp),
            )
        },
        trailingContent = {
            Row {
                when (internalDbStatus) {
                    InternalDatabaseStatus.NOT_FOUND -> {}
                    InternalDatabaseStatus.MATCH -> Icon(
                        Icons.Filled.Verified,
                        "Verified successfully with internal database",
                        Modifier,
                        SimpleVerificationStatus.SUCCESS.color,
                    )
                    InternalDatabaseStatus.NOMATCH -> Icon(
                        Icons.Filled.Error,
                        "Verification with internal database NOT successful!",
                        Modifier,
                        SimpleVerificationStatus.FAILURE.color,
                    )
                }
                when (sharedHashMatch) {
                    true -> Icon(
                        Icons.Filled.Verified,
                        "Shared text hashes match installed app",
                        Modifier,
                        Color(0xFFFF9800),
                    )
                    false -> Icon(
                        Icons.Filled.Error,
                        "Shared text hashes do NOT match installed app",
                        Modifier,
                        Color(0xFFFF9800),
                    )
                    null -> {}
                }
            }
        }
    )
}
