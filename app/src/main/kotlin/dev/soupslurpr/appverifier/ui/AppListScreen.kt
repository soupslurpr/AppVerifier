package dev.soupslurpr.appverifier.ui

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.accompanist.drawablepainter.rememberDrawablePainter

@Composable
fun AppListScreen(
    onClickAppItem: (
        name: String,
        packageName: String,
        hash: String,
        icon: Drawable
    ) -> Unit,
    onLaunchedEffect: () -> Unit,
    getHashHexFromPackageInfo: (packageInfo: PackageInfo) -> String,
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

    LazyColumn {
        items(userInstalledPackages) {
            // Do not show AppVerifier in the list as there is no point in using it to verify itself.
            if (it.packageName != context.packageName) {
                val packageInfo = packageManager.getPackageInfo(it.packageName, PackageManager.GET_SIGNING_CERTIFICATES)

                val hashHex = getHashHexFromPackageInfo(packageInfo)

                AppItem(
                    name = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString(),
                    packageName = packageInfo.packageName,
                    hash = hashHex,
                    icon = packageManager.getApplicationIcon(packageInfo.applicationInfo),
                    onClickAppItem = onClickAppItem,
                )
            }
        }
    }
}

@Composable
fun AppItem(
    name: String,
    packageName: String,
    hash: String,
    icon: Drawable,
    onClickAppItem: (name: String, packageName: String, hash: String, icon: Drawable) -> Unit,
) {
    ListItem(
        modifier = Modifier.clickable {
            onClickAppItem(name, packageName, hash, icon)
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
        }
    )
}