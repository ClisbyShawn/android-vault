package com.clisbyshawn.vault.entry.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.clisbyshawn.vault.R
import com.clisbyshawn.vault.theme.PreviewScreen

@Composable
fun InputTextFieldToVault() {
    var text by remember { mutableStateOf("Hello Vault!!!") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        minLines = 3,
        maxLines = 3,
        label = { Text(stringResource(R.string.text_field_enter_secret_message_label)) },
        trailingIcon = { Icons.Outlined.Clear })
}


@PreviewLightDark
@Composable
private fun Preview_InputToVault() {
    PreviewScreen {
        InputTextFieldToVault()
    }
}