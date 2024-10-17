package dev.soupslurpr.appverifier.ui

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import dev.soupslurpr.appverifier.data.Hashes
import dev.soupslurpr.appverifier.data.InternalDatabaseInfo
import dev.soupslurpr.appverifier.data.InternalDatabaseStatus
import dev.soupslurpr.appverifier.data.SimpleVerificationStatus
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

    LaunchedEffect(key1 = Unit) {
        onLaunchedEffect()
    }

    Scaffold(
        modifier = Modifier.testTag("AppList"),
        topBar = {
            DockedSearchBar(
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                placeholder = { Text(stringResource(android.R.string.search_go)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 8.dp),
                query = searchQuery,
                onQueryChange = onQueryChange,
                onSearch = onSearch,
                active = false,
                onActiveChange = onSearchActiveChange,
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
            items(userInstalledPackages) {
                // Do not show AppVerifier in the list as there is no point in using it to verify itself.
                if (it.packageName == context.packageName) return@items

                val packageInfo = packageManager.getPackageInfo(
                    it.packageName,
                    PackageManager.GET_SIGNING_CERTIFICATES
                )
                val name = packageManager.getApplicationLabel(packageInfo.applicationInfo)
                    .toString()

                if (searchQuery == "" || name.contains(searchQuery, true) ||
                    it.packageName.contains(searchQuery, true))
                {
                    val hashes = getHashesFromPackageInfo(packageInfo)

                    val verificationInfo = VerificationInfo(packageInfo.packageName, hashes)

                    AppItem(
                        name = name,
                        packageName = packageInfo.packageName,
                        hashes = hashes,
                        icon = packageManager.getApplicationIcon(packageInfo.applicationInfo),
                        onClickAppItem = onClickAppItem,
                        internalDatabaseInfo = getInternalDatabaseInfoFromVerificationInfo(verificationInfo),
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
            when (internalDatabaseInfo.internalDatabaseStatus) {
                InternalDatabaseStatus.NOT_FOUND -> null
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
        }
    )
}