package com.clisbyshawn.vault.vault.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.clisbyshawn.vault.theme.PreviewScreen

@Composable
fun TheVault(
    onNavigateBack:() -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("The Vault", modifier = Modifier.clickable { onNavigateBack() })
    }
}


@PreviewLightDark
@Composable
private fun Preview_TheVault() {
    PreviewScreen {
        TheVault {}
    }
}