package com.clisbyshawn.vault.theme

import androidx.compose.runtime.Composable


@Composable
fun PreviewScreen(content: @Composable () -> Unit) {
    VaultTheme {
        content()
    }
}