package dev.soupslurpr.appverifier.settings

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey

/** Preference pairs, the first is the preference key, and the second is the default value. */
data class PreferencesUiState(
    /** Whether the user has accepted the privacy policy and license. */
    val acceptedPrivacyPolicyAndLicense: Pair<Preferences.Key<Boolean>, MutableState<Boolean>> = Pair(
        (booleanPreferencesKey("ACCEPTED_PRIVACY_POLICY_AND_LICENSE")),
        mutableStateOf(false)
    ),

    /** Pitch black background. */
    val pitchBlackBackground: Pair<Preferences.Key<Boolean>, MutableState<Boolean>> = Pair(
        (booleanPreferencesKey("PITCH_BLACK_BACKGROUND")),
        mutableStateOf(false)
    ),
)