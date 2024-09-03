package com.clisbyshawn.vault.entry.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.clisbyshawn.vault.R
import com.clisbyshawn.vault.entry.ui.component.InputButtonToVault
import com.clisbyshawn.vault.entry.ui.component.InputTextFieldToVault
import com.clisbyshawn.vault.theme.Dimens
import com.clisbyshawn.vault.theme.PreviewScreen

@Composable
fun EntryScreen(
    onEncryption: () -> Unit,
    onAddToVault: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.padding(horizontal = Dimens.defaultPadding)
        ) {
            InputTextFieldToVault()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = Dimens.defaultPadding),
                horizontalArrangement = Arrangement.Absolute.SpaceEvenly
            ) {
                InputButtonToVault(R.string.button_encryption_label, onEncryption)
                InputButtonToVault(R.string.button_add_to_vault_label, onAddToVault)
            }
        }
    }
}


@PreviewLightDark
@Composable
private fun Preview_EntryScreen() {
    PreviewScreen {
        EntryScreen(onEncryption = {}, onAddToVault = {})
    }
}