package dev.soupslurpr.appverifier

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.soupslurpr.appverifier.data.UserDatabaseEntry
import dev.soupslurpr.appverifier.data.parseUserDatabaseEntriesFromText
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

            val isActionView =
                (intent.action == Intent.ACTION_VIEW)

            var sharedFilteredEntries by remember { mutableStateOf<List<UserDatabaseEntry>?>(null) }

            if (isActionSend) {
                val extraText = intent.getStringExtra(Intent.EXTRA_TEXT)
                val extraStream: Uri? = intent.getParcelableExtra(Intent.EXTRA_STREAM)

                val sharedText = when {
                    extraText != null -> extraText
                    extraStream != null && intent.type?.startsWith("text/") == true -> {
                        contentResolver.openInputStream(extraStream)?.bufferedReader()?.use { it.readText() }
                    }
                    else -> null
                }

                if (sharedText != null) {
                    val trimmed = sharedText.trim()
                    val entries = trimmed.split("\n\n").filter { it.isNotBlank() }
                    if (entries.size > 1) {
                        val parsed = parseUserDatabaseEntriesFromText(trimmed)
                        if (parsed != null) {
                            sharedFilteredEntries = parsed
                        } else {
                            val packageNames = entries.mapNotNull { entry ->
                                entry.lines().firstOrNull()?.trim()?.takeIf { it.isNotBlank() }
                            }
                            if (packageNames.isNotEmpty()) {
                                sharedFilteredEntries = packageNames.map { UserDatabaseEntry(it, emptyList(), false) }
                            }
                        }
                    } else {
                        val verificationInfoText = verifyAppViewModel.getVerificationInfoText(sharedText)
                        verifyAppViewModel.findAndSetAppVerificationInfoFromPackageName(
                            verificationInfoText.lines()[0],
                            packageManager
                        )
                        verifyAppViewModel.verifyFromText(verificationInfoText)
                    }
                } else if (extraStream != null) {
                    verifyAppViewModel.setApkVerificationInfoAndInternalDatabaseStatusFromUri(
                        contentResolver,
                        extraStream,
                        packageManager
                    )
                }
            } else if (isActionView) {
                if (intent.data != null) {
                    intent.data?.let {
                        verifyAppViewModel.setApkVerificationInfoAndInternalDatabaseStatusFromUri(
                            contentResolver,
                            it,
                            packageManager
                        )
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
                        isActionView = isActionView,
                        sharedFilteredEntries = sharedFilteredEntries,
                    )
                }
            }
        }
    }
}