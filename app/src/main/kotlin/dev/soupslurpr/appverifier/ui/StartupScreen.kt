package dev.soupslurpr.appverifier.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FileOpen
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.soupslurpr.appverifier.R

@Composable
fun StartupScreen(
    modifier: Modifier,
    splashMessage: String,
    onSettingsButtonClicked: () -> Unit,
    onAppListButtonClicked: () -> Unit,
    verifyAppViewModel: VerifyAppViewModel,
    onVerifyApkFileButtonClicked: () -> Unit,
) {
    // clear VerifyAppUiState when exiting VerifyAppScreen from opening an apk and going back to StartupScreen.
    LaunchedEffect(key1 = Unit) {
        verifyAppViewModel.clearUiState()
    }

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .background(colorResource(id = R.color.ic_launcher_background))
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = modifier.requiredSize(300.dp)
            )
        }
        Text(
            text = stringResource(R.string.welcome),
            style = typography.headlineLarge
        )
        Text(
            text = splashMessage,
            style = typography.bodySmall,
            textAlign = TextAlign.Center
        )
        FilledTonalButton(
            modifier = modifier.fillMaxWidth(),
            onClick = { onAppListButtonClicked() }
        ) {
            Icon(
                imageVector = Icons.Filled.List,
                contentDescription = null
            )
            Spacer(modifier = modifier.width(8.dp))
            Text("App List")
        }
        FilledTonalButton(
            modifier = modifier.fillMaxWidth(),
            onClick = { onVerifyApkFileButtonClicked() }
        ) {
            Icon(
                Icons.Filled.FileOpen,
                null
            )
            Spacer(Modifier.width(8.dp))
            Text("Verify APK File")
        }
        FilledTonalButton(
            modifier = modifier.fillMaxWidth(),
            onClick = { onSettingsButtonClicked() }
        ) {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = null
            )
            Spacer(modifier = modifier.width(8.dp))
            Text(stringResource(R.string.settings))
        }

        Spacer(Modifier.padding(WindowInsets.navigationBars.asPaddingValues()))
    }
}
