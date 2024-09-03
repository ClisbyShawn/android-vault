package com.clisbyshawn.vault.entry.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.clisbyshawn.vault.R
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
            var text by remember { mutableStateOf("Hello Vault!!!") }

            OutlinedTextField(value = text,
                onValueChange = { text = it },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                minLines = 3,
                maxLines = 3,
                label = { Text(stringResource(R.string.text_field_enter_secret_message_label)) },
                trailingIcon = { Icons.Outlined.Clear })

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = Dimens.defaultPadding),
                horizontalArrangement = Arrangement.Absolute.SpaceEvenly
            ) {
                Button(onClick = onEncryption) {
                    Text(text = stringResource(R.string.button_encryption_label))
                }
                Button(onClick = onAddToVault) {
                    Text(text = stringResource(R.string.button_add_to_vault_label))
                }
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