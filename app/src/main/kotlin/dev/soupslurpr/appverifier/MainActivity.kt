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
                val text = intent.getStringExtra(Intent.EXTRA_TEXT)

                if (text != null) {
                    val verificationInfoText = verifyAppViewModel.getVerificationInfoText(text)

                    verifyAppViewModel.findAndSetAppVerificationInfoFromPackageName(
                        verificationInfoText.lines()[0],
                        packageManager
                    )
                    verifyAppViewModel.verifyFromText(verificationInfoText)
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