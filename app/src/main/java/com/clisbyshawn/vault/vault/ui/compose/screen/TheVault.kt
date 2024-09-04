package com.clisbyshawn.vault.vault.ui.compose.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.clisbyshawn.vault.theme.PreviewScreen
import com.clisbyshawn.vault.vault.ui.model.VaultUiState

@Composable
fun TheVault(
    uiState: VaultUiState,
    onNavigateBack: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(8.dp)
    ) {
        items(uiState.hiddenItems) { item ->
            Text(item,
                modifier = Modifier
                    .clickable { onNavigateBack() }

            )
        }
    }
}


@PreviewLightDark
@Composable
private fun Preview_TheVault() {
    PreviewScreen {
        TheVault(
            VaultUiState(
                hiddenItems = listOf("Random Text", "More random Text")
            ),
            onNavigateBack = {}
        )
    }
}