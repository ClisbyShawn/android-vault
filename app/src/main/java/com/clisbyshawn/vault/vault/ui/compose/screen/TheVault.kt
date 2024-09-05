package com.clisbyshawn.vault.vault.ui.compose.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.clisbyshawn.vault.theme.Dimens
import com.clisbyshawn.vault.theme.PreviewScreen
import com.clisbyshawn.vault.vault.ui.model.VaultUiState

@Composable
fun TheVault(
    uiState: VaultUiState,
    onDecode: () -> Unit,
    onNavigateBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(
            Dimens.defaultPadding,
            Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(text = uiState.decryptedText.ifBlank { uiState.encryptedText ?: "Error" },
            modifier = Modifier
                .clickable { onNavigateBack() }

        )



        Button(onClick = onDecode) {
            Text("Click to Decode Message")
        }
    }

}


@PreviewLightDark
@Composable
private fun Preview_TheVault() {
    PreviewScreen {
        TheVault(
            VaultUiState(
                encryptedText = "********",
                decryptedText = "Hello World"
            ),
            onDecode = {},
            onNavigateBack = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun Preview_TheVault_Encrypted() {
    PreviewScreen {
        TheVault(
            VaultUiState(
                encryptedText = "********",
                decryptedText = ""
            ),
            onDecode = {},
            onNavigateBack = {}
        )
    }
}