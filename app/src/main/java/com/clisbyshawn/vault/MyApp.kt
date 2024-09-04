package com.clisbyshawn.vault

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.clisbyshawn.vault.navigation.MyAppNavHost
import com.clisbyshawn.vault.theme.VaultTheme


@Composable
fun MyApp() {
    VaultTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            MyAppNavHost()
        }
    }
}