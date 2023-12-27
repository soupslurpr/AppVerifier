package dev.soupslurpr.appverifier.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import dev.soupslurpr.appverifier.preferences.PreferencesViewModel

/**
 * Dark color scheme for devices < Android 12, which do not support dynamic color.
 */
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
)

/**
 * Light color scheme for devices < Android 12, which do not support dynamic color.
 */
private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun AppVerifierTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    preferencesViewModel: PreferencesViewModel,
    content: @Composable () -> Unit
) {
    val settingsUiState by preferencesViewModel.uiState.collectAsState()

    val pitchBlackBackground = settingsUiState.pitchBlackBackground.second.value and darkTheme

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) {
                if (pitchBlackBackground) {
                    dynamicDarkColorScheme(context).copy(
                        background = Color.Black,
                        surface = Color.Black,
                    )
                } else {
                    dynamicDarkColorScheme(context)
                }
            } else {
                dynamicLightColorScheme(context)
            }
        }

        darkTheme -> {
            if (pitchBlackBackground) {
                DarkColorScheme.copy(
                    background = Color.Black,
                    surface = Color.Black
                )
            } else {
                DarkColorScheme
            }
        }

        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}