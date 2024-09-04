package com.clisbyshawn.vault.entry.ui.component

import androidx.annotation.StringRes
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.clisbyshawn.vault.theme.PreviewScreen

@Composable
fun InputButtonToVault(
    @StringRes textId: Int,
    onClick: () -> Unit
) {
    Button(onClick = onClick) {
        Text(text = stringResource(textId))
    }
}


@Preview
@Composable
private fun Preview_InputButtonToVault() {

    PreviewScreen {
        InputButtonToVault(0) {}
    }

}