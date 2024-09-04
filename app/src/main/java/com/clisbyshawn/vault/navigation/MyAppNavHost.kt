package com.clisbyshawn.vault.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.clisbyshawn.vault.entry.ui.screen.EntryScreen
import com.clisbyshawn.vault.navigation.MyAppHostRoute.Vault
import com.clisbyshawn.vault.navigation.MyAppHostRoute.VaultEntry
import com.clisbyshawn.vault.vault.ui.screen.TheVault

@Composable
fun MyAppNavHost(
    navController: NavHostController = rememberNavController()
) {

    NavHost(navController = navController, startDestination = VaultEntry.route) {

        composable(route = VaultEntry.route) {
            EntryScreen(
                onEncryption = {},
                onAddToVault = {},
                navigateToVault = { navController.navigate(Vault.route) }
            )
        }

        composable(route = Vault.route) {
            TheVault(onNavigateBack = { navController.popBackStack() })
        }
    }

}