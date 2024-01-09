package dev.soupslurpr.appverifier.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.soupslurpr.appverifier.R

@Composable
fun DonationScreen() {
    val columnVerticalScroll = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(columnVerticalScroll),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            "Like AppVerifier? You can donate to soupslurpr, the lead developer of AppVerifier to support their work" +
                    " on AppVerifier and their other open source projects. Thank you!"
        )
        Text("")
        Text("Monero address:")
        SelectionContainer {
            Text("88rAaNowhaC8JG8NJDpcdRWr1gGVmtFPnHWPS9xXvqY44G4XKVi5hZMax2FQ6B8KAcMpzkeJAhNek8qMHZjjwvkEKuiyBKF")
        }
        Text("")
        Image(
            painterResource(R.drawable.donation_monero_address_qrcode),
            contentDescription = "QR Code for Monero address"
        )

        Spacer(Modifier.padding(WindowInsets.navigationBars.asPaddingValues()))
    }
}