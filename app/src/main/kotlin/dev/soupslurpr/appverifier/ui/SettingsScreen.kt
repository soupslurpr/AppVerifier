package dev.soupslurpr.appverifier.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.soupslurpr.appverifier.R
import dev.soupslurpr.appverifier.preferences.PreferencesViewModel
import kotlinx.coroutines.launch

/**
 * Composable for settings screen
 */
@Composable
fun SettingsScreen(
    onLicenseIconButtonClicked: () -> Unit,
    onPrivacyPolicyIconButtonClicked: () -> Unit,
    onCreditsIconButtonClicked: () -> Unit,
    preferencesViewModel: PreferencesViewModel,
    onDonationSettingsItemClicked: () -> Unit,
) {
    val localUriHandler = LocalUriHandler.current
    val preferencesUiState by preferencesViewModel.uiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Column {
            SettingsCategoryText(category = stringResource(id = R.string.theme))
            SettingsItem(
                name = stringResource(id = R.string.pitch_black_background_setting_name),
                description = stringResource(id = R.string.pitch_black_background_setting_description),
                hasSwitch = true,
                checked = preferencesUiState.pitchBlackBackground.second.value,
                onCheckedChange = {
                    coroutineScope.launch {
                        preferencesViewModel.setPreference(preferencesUiState.pitchBlackBackground.first, it)
                    }
                }
            )
        }

        Column {
            SettingsCategoryText(category = stringResource(id = R.string.about))
//            SettingsItem(
//                name = stringResource(id = R.string.open_appverifier_website_setting_name),
//                description = stringResource(id = R.string.open_appverifier_website_setting_description),
//                hasIcon = true,
//                onClickIconSetting = {
//                    localUriHandler.openUri("https://appverifier.soupslurpr.dev")
//                },
//                icon = {
//                    Icon(
//                        imageVector = Icons.Filled.ExitToApp,
//                        contentDescription = null
//                    )
//                }
//            )
            SettingsItem(
                name = stringResource(id = R.string.view_source_code_setting_name),
                description = stringResource(id = R.string.view_source_code_setting_description),
                hasIcon = true,
                onClickIconSetting = {
                    localUriHandler.openUri("https://github.com/soupslurpr/AppVerifier")
                },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.ExitToApp,
                        contentDescription = null
                    )
                }
            )
            SettingsItem(
                name = stringResource(id = R.string.license_setting_name),
                description = stringResource(id = R.string.license_setting_description),
                hasIcon = true,
                onClickIconSetting = { onLicenseIconButtonClicked() },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = null
                    )
                }
            )
            SettingsItem(
                name = stringResource(id = R.string.privacy_policy_setting_name),
                description = stringResource(id = R.string.privacy_policy_setting_description),
                hasIcon = true,
                onClickIconSetting = { onPrivacyPolicyIconButtonClicked() },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = null,
                    )
                }
            )
            SettingsItem(
                name = stringResource(id = R.string.credits_setting_name),
                description = stringResource(id = R.string.credits_setting_description),
                hasIcon = true,
                onClickIconSetting = { onCreditsIconButtonClicked() },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = null
                    )
                }
            )
            SettingsItem(
                stringResource(R.string.donation_setting_name),
                stringResource(R.string.donation_setting_description),
                hasIcon = true,
                onClickIconSetting = { onDonationSettingsItemClicked() },
                icon = {
                    Icon(
                        Icons.Filled.Info,
                        null
                    )
                }
            )
        }

        Spacer(Modifier.padding(WindowInsets.navigationBars.asPaddingValues()))
    }
}

/**
 * An individual settings item
 */
@Composable
fun SettingsItem(
    name: String,
    description: String,
    hasSwitch: Boolean = false,
    hasIcon: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {},
    checked: Boolean = false,
    onClickIconSetting: () -> Unit = {},
    icon: @Composable () -> Unit = {},
) {
    ListItem(
        modifier = when {
            hasIcon -> Modifier.clickable(onClick = { onClickIconSetting() })
            hasSwitch -> Modifier.toggleable(
                value = checked,
                onValueChange = { onCheckedChange(it) }
            )

            else -> Modifier
        },
        headlineContent = {
            Text(
                text = name,
                fontWeight = FontWeight.SemiBold
            )
        },
        supportingContent = { Text(text = description) },
        trailingContent = {
            when {
                hasIcon -> icon()
                hasSwitch -> Switch(
                    checked = checked,
                    onCheckedChange = null,
                )
            }
        }
    )
}

@Composable
fun SettingsCategoryText(category: String) {
    Text(
        text = category,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(8.dp),
        style = typography.bodyMedium,
        fontWeight = FontWeight.Bold
    )
}