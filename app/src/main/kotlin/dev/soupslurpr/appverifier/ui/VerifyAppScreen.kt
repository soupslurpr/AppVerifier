package dev.soupslurpr.appverifier.ui

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import dev.soupslurpr.appverifier.data.Hashes
import dev.soupslurpr.appverifier.data.InternalDatabaseInfo
import dev.soupslurpr.appverifier.data.InternalDatabaseStatus
import dev.soupslurpr.appverifier.data.VerificationStatus

@Composable
fun VerifyAppScreen(
    icon: Drawable?,
    name: String,
    packageName: String,
    hashes: Hashes,
    verificationStatus: VerificationStatus,
    appNotFound: Boolean,
    onVerifyFromClipboard: (String) -> Unit,
    onLaunchedEffectHashEmpty: () -> Unit,
    internalDatabaseInfo: InternalDatabaseInfo,
    apkFailedToParse: Boolean,
    showHasMultipleSigners: Boolean,
    showClipboardEmptyMessage: () -> Unit,
) {
    val context = LocalContext.current

    val clipboardManager = LocalClipboardManager.current

    val verticalScroll = rememberScrollState()

    var showMoreInfoAboutVerificationStatusDialog by rememberSaveable { mutableStateOf(false) }

    var showMoreInfoAboutInternalDatabaseStatusDialog by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        if (hashes.hashes.isEmpty()) {
            onLaunchedEffectHashEmpty()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(verticalScroll),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (apkFailedToParse) {
            Text("APK FAILED TO PARSE")
            Text(
                "Make sure you provided a valid apk file."
            )
        } else if (appNotFound) {
            Text("APP NOT INSTALLED OR INVALID FORMAT")
            Text(
                "The package name doesn't seem to correspond to any installed user app." +
                        "\nPlease note system apps are not included in the search."
            )
            Text(
                "Also please make sure the provided text is in the correct format, like the " +
                        "following:\n\ncom.example" +
                        ".app\n96:C0:2C:55:75:5C:17:1C:68:13:70:29:3B:37:11:2B:4A:5D:F7:B9:82:C2:C5:58:05:4C:45:51:AD:F5:50:DC" +
                        "\n\nThere may be multiple hashes, which is normal."
            )
        } else {
            Text(
                "Internal Database Status:"
            )
            Row {
                FilledTonalButton(
                    onClick = { showMoreInfoAboutInternalDatabaseStatusDialog = true },
                ) {
                    Text(
                        internalDatabaseInfo.internalDatabaseStatus.simpleInternalDatabaseStatus.name.replace('_', ' '),
                        style = typography.headlineLarge
                    )
                    Spacer(Modifier.width(8.dp))
                    Icon(
                        Icons.Default.Info,
                        "More info about internal database status",
                        tint = internalDatabaseInfo.internalDatabaseStatus.simpleInternalDatabaseStatus.color,
                    )
                }
            }
            Spacer(Modifier.height(8.dp))
            if (icon != null) {
                Image(
                    rememberDrawablePainter(drawable = icon),
                    null,
                    Modifier.size(150.dp),
                )
            }
            Text(
                text = name,
                style = typography.titleLarge
            )
            Text(text = packageName)
            Text(
                text = hashes.hashes.joinToString("\n"),
                fontFamily = FontFamily.Monospace
            )
            if (showHasMultipleSigners) {
                Text(
                    "hasMultipleSigners: "
                )
                Text(
                    hashes.hasMultipleSigners.toString(),
                    fontWeight = FontWeight.Black
                )
            }
            Button(onClick = {
                val sendIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "$packageName\n${hashes.hashes.joinToString("\n")}")
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(
                    sendIntent,
                    null,
                )

                startActivity(context, shareIntent, ActivityOptions.makeBasic().toBundle())
            }) {
                Text("Share/Copy Verification Info")
            }
            Button(onClick = {
                if (clipboardManager.hasText()) {
                    onVerifyFromClipboard(clipboardManager.getText()!!.text)
                } else {
                    showClipboardEmptyMessage()
                }
            }) {
                Text("Verify from clipboard")
            }
            Text(
                "Verification Status:",
            )
            Row {
                FilledTonalButton(
                    onClick = { showMoreInfoAboutVerificationStatusDialog = true },
                ) {
                    Text(
                        verificationStatus.simpleVerificationStatus.name,
                        style = typography.headlineLarge
                    )
                    Spacer(Modifier.width(8.dp))
                    Icon(
                        Icons.Default.Info,
                        "More info about verification status",
                        tint = verificationStatus.simpleVerificationStatus.color,
                    )
                }
            }
        }

        Spacer(Modifier.padding(WindowInsets.navigationBars.asPaddingValues()))
    }

    if (showMoreInfoAboutInternalDatabaseStatusDialog) {
        AlertDialog(
            onDismissRequest = { showMoreInfoAboutInternalDatabaseStatusDialog = false },
            confirmButton = {
                TextButton(
                    { showMoreInfoAboutInternalDatabaseStatusDialog = false }
                ) {
                    Text(stringResource(id = android.R.string.ok))
                }
            },
            title = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        internalDatabaseInfo.internalDatabaseStatus.name,
                        style = typography.headlineSmall,
                        color = internalDatabaseInfo.internalDatabaseStatus.simpleInternalDatabaseStatus.color,
                    )
                }
            },
            text = {
                LazyColumn {
                    item {
                        Text(internalDatabaseInfo.internalDatabaseStatus.info)
                    }
                    item {
                        if (internalDatabaseInfo.internalDatabaseStatus == InternalDatabaseStatus.MATCH) {
                            Text("\nThe matched database entry for this app is from the following sources:\n")
                            Text(
                                text = internalDatabaseInfo.sources.joinToString("\n") { it.displayName },
                                style = typography.headlineSmall,
                            )
                            Text(
                                "\nThis information can be useful if you distrust a specific source and want to make" +
                                        " sure the app isn't from them."
                            )
                        }
                    }
                }
            }
        )
    }

    if (showMoreInfoAboutVerificationStatusDialog) {
        AlertDialog(
            onDismissRequest = { showMoreInfoAboutVerificationStatusDialog = false },
            confirmButton = {
                TextButton(
                    { showMoreInfoAboutVerificationStatusDialog = false }
                ) {
                    Text(stringResource(id = android.R.string.ok))
                }
            },
            title = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        verificationStatus.name,
                        style = typography.headlineSmall,
                        color = verificationStatus.simpleVerificationStatus.color,
                    )
                }
            },
            text = {
                LazyColumn {
                    item {
                        Text(verificationStatus.info)
                    }
                }
            }
        )
    }
}