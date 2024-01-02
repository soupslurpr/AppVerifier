package dev.soupslurpr.appverifier

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.soupslurpr.appverifier.preferences.PreferencesViewModel
import dev.soupslurpr.appverifier.ui.ReviewPrivacyPolicyAndLicense
import dev.soupslurpr.appverifier.ui.VerifyAppViewModel
import dev.soupslurpr.appverifier.ui.theme.AppVerifierTheme

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "preferences")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            val verifyAppViewModel: VerifyAppViewModel = viewModel()

            val preferencesViewModel: PreferencesViewModel = viewModel(
                factory = PreferencesViewModel.PreferencesViewModelFactory(dataStore)
            )

            val isActionSend =
                (intent.action == Intent.ACTION_SEND)

            if (isActionSend) {
                val lines = intent.getStringExtra(Intent.EXTRA_TEXT)?.trim()?.lines()

                if (lines != null) {
                    if (lines[0].contains(' ')) {
                        val split = lines[0].trim('"').split(' ')
                        if (split.size == 2) {
                            val packageName = split[0].trim()
                            val hash = split[1].trim()

                            verifyAppViewModel.findAndSetAppVerificationInfoFromPackageName(packageName, packageManager)
                            verifyAppViewModel.verifyFromText("$packageName\n$hash")
                        } else {
                            verifyAppViewModel.setInvalidFormat(true)
                        }
                    } else if (lines[0].contains('"') && lines[1].contains('"')) {
                        val packageName = lines[0].trim().trim('"')
                        val hash = lines[1].trim().trim('"')

                        verifyAppViewModel.findAndSetAppVerificationInfoFromPackageName(packageName, packageManager)
                        verifyAppViewModel.verifyFromText("$packageName\n$hash")
                    } else if (lines.size == 2) {
                        val packageName = lines[0].trim()
                        val hash = lines[1].trim()

                        verifyAppViewModel.findAndSetAppVerificationInfoFromPackageName(packageName, packageManager)
                        verifyAppViewModel.verifyFromText("$packageName\n$hash")
                    } else {
                        verifyAppViewModel.setInvalidFormat(true)
                    }
                }
            }

            val preferencesUiState by preferencesViewModel.uiState.collectAsState()

            AppVerifierTheme(
                preferencesViewModel = preferencesViewModel
            ) {
                if (!preferencesUiState.acceptedPrivacyPolicyAndLicense.second.value) {
                    ReviewPrivacyPolicyAndLicense(preferencesViewModel = preferencesViewModel)
                } else if (preferencesUiState.acceptedPrivacyPolicyAndLicense.second.value) {
                    AppVerifierApp(
                        modifier = Modifier,
                        verifyAppViewModel = verifyAppViewModel,
                        preferencesViewModel = preferencesViewModel,
                        isActionSend = isActionSend,
                    )
                }
            }
        }
    }
}