package com.clisbyshawn.vault.util

import androidx.compose.runtime.Composable
import com.clisbyshawn.vault.theme.VaultTheme


@Composable
fun PreviewScreen(content: @Composable () -> Unit) {
    VaultTheme {
        content()
    }
}