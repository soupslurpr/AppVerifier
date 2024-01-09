package dev.soupslurpr.appverifier

import android.graphics.drawable.Drawable
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.soupslurpr.appverifier.data.Hashes
import dev.soupslurpr.appverifier.data.InternalDatabaseStatus
import dev.soupslurpr.appverifier.preferences.PreferencesViewModel
import dev.soupslurpr.appverifier.ui.AppListScreen
import dev.soupslurpr.appverifier.ui.CreditsScreen
import dev.soupslurpr.appverifier.ui.DonationScreen
import dev.soupslurpr.appverifier.ui.LicenseScreen
import dev.soupslurpr.appverifier.ui.PrivacyPolicyScreen
import dev.soupslurpr.appverifier.ui.SettingsScreen
import dev.soupslurpr.appverifier.ui.StartupScreen
import dev.soupslurpr.appverifier.ui.VerifyAppScreen
import dev.soupslurpr.appverifier.ui.VerifyAppViewModel
import kotlin.random.Random

enum class AppVerifierScreens(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    AppList(title = R.string.app_list),
    VerifyApp(title = R.string.verify_app),
    Settings(title = R.string.settings),
    License(title = R.string.license),
    PrivacyPolicy(title = R.string.privacy_policy),
    Credits(title = R.string.credits),
    Donation(title = R.string.donation)
}

@Composable
fun AppVerifierAppBar(
) {

}

@Composable
fun AppVerifierApp(
    modifier: Modifier,
    verifyAppViewModel: VerifyAppViewModel,
    preferencesViewModel: PreferencesViewModel,
    isActionSend: Boolean,
    isActionView: Boolean,
) {
    val verifyAppUiState = verifyAppViewModel.uiState.collectAsState()

    val navController = rememberNavController()

//    val backStackEntry by navController.currentBackStackEntryAsState()

//    val currentScreen = AppVerifierScreens.valueOf(
//        backStackEntry?.destination?.route ?: AppVerifierScreens.Start.name
//    )

    val randomValue = Random.nextInt(0, 10)
    val splashMessage = rememberSaveable {
        when (randomValue) {
            0 -> "Gotta verify 'em all!"
            else -> "App verification, but easy."
        }
    }

    val context = LocalContext.current

    val openApkFileLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.OpenDocument()) { uri ->
            if (uri != null) {
                verifyAppViewModel.setApkVerificationInfoAndInternalDatabaseStatusFromUri(
                    context.contentResolver,
                    uri,
                    context.packageManager,
                )
                navController.navigate(AppVerifierScreens.VerifyApp.name)
            }
        }

    Scaffold(
        topBar = {
            AppVerifierAppBar()
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = if (isActionSend || isActionView) {
                AppVerifierScreens.VerifyApp.name
            } else {
                AppVerifierScreens.Start.name
            },
            modifier = modifier.padding(
                innerPadding.calculateStartPadding(LayoutDirection.Ltr),
                innerPadding.calculateTopPadding(),
                innerPadding.calculateEndPadding(LayoutDirection.Ltr)
            ),
        ) {
            composable(route = AppVerifierScreens.Start.name) {
                StartupScreen(
                    modifier = modifier,
                    splashMessage = splashMessage,
                    onSettingsButtonClicked = {
                        navController.navigate(AppVerifierScreens.Settings.name)
                    },
                    onAppListButtonClicked = {
                        navController.navigate(AppVerifierScreens.AppList.name)
                    },
                    verifyAppViewModel = verifyAppViewModel,
                    onVerifyApkFileButtonClicked = {
                        openApkFileLauncher.launch(arrayOf("application/vnd.android.package-archive"))
                    },
                )
            }
            composable(route = AppVerifierScreens.AppList.name) {
                AppListScreen(
                    { name: String, packageName: String, hashes: Hashes, icon: Drawable, internalDatabaseStatus:
                    InternalDatabaseStatus ->
                        verifyAppViewModel.setAppVerificationInfo(name, packageName, hashes, internalDatabaseStatus)
                        verifyAppViewModel.setAppIcon(icon)
                        navController.navigate(AppVerifierScreens.VerifyApp.name)
                    },
                    { verifyAppViewModel.clearUiState() },
                    { verifyAppViewModel.getHashesFromPackageInfo(it) },
                    { verifyAppViewModel.getInternalDatabaseStatusFromVerificationInfo(it) }
                )
            }
            composable(route = AppVerifierScreens.VerifyApp.name) {
                VerifyAppScreen(
                    verifyAppUiState.value.icon.value,
                    verifyAppUiState.value.name.value,
                    verifyAppUiState.value.packageName.value,
                    verifyAppUiState.value.hashes.value,
                    verifyAppUiState.value.verificationStatus.value,
                    verifyAppUiState.value.appNotFoundOrInvalidFormat.value,
                    { verifyAppViewModel.verifyFromText(it) },
                    { navController.navigateUp() },
                    verifyAppUiState.value.internalDatabaseStatus.value,
                    verifyAppUiState.value.apkFailedToParse.value,
                )
            }
            composable(route = AppVerifierScreens.Settings.name) {
                SettingsScreen(
                    onLicenseIconButtonClicked = {
                        navController.navigate(AppVerifierScreens.License.name)
                    },
                    onPrivacyPolicyIconButtonClicked = {
                        navController.navigate(AppVerifierScreens.PrivacyPolicy.name)
                    },
                    onCreditsIconButtonClicked = {
                        navController.navigate(AppVerifierScreens.Credits.name)
                    },
                    preferencesViewModel = preferencesViewModel,
                    onDonationSettingsItemClicked = {
                        navController.navigate(AppVerifierScreens.Donation.name)
                    }
                )
            }
            composable(route = AppVerifierScreens.License.name) {
                LicenseScreen()
            }
            composable(route = AppVerifierScreens.PrivacyPolicy.name) {
                PrivacyPolicyScreen()
            }
            composable(route = AppVerifierScreens.Credits.name) {
                CreditsScreen()
            }
            composable(route = AppVerifierScreens.Donation.name) {
                DonationScreen()
            }
        }
    }
}



