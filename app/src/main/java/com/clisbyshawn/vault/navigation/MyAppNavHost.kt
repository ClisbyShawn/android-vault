package com.clisbyshawn.vault.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.clisbyshawn.vault.entry.ui.model.EntryScreenUiState
import com.clisbyshawn.vault.entry.ui.screen.EntryScreen
import com.clisbyshawn.vault.entry.ui.viewmodel.EntryViewModel
import com.clisbyshawn.vault.navigation.MyAppHostScreens.Vault
import com.clisbyshawn.vault.navigation.MyAppHostScreens.VaultEntry
import com.clisbyshawn.vault.vault.ui.compose.screen.TheVault
import com.clisbyshawn.vault.vault.ui.model.VaultUiState
import com.clisbyshawn.vault.vault.ui.viewmodel.TheVaultViewModel

@Composable
fun MyAppNavHost(
    navController: NavHostController = rememberNavController()
) {

    NavHost(navController = navController, startDestination = VaultEntry.route) {
        composable(route = VaultEntry.route) {
            val viewModel: EntryViewModel = hiltViewModel()
            val uiState: EntryScreenUiState by viewModel.uiState.collectAsStateWithLifecycle()

            EntryScreen(
                uiState = uiState,
                onAddToVault = viewModel::onAddToVault,
                onTextChanged = viewModel::onTextChanged,
                navigateToVault = { navController.navigate(Vault.route) }
            )
        }

        composable(route = Vault.route) {
            val viewModel: TheVaultViewModel = hiltViewModel()
            val uiState: VaultUiState by viewModel.uiState.collectAsStateWithLifecycle()
            TheVault(uiState = uiState, onNavigateBack = { navController.popBackStack() })
        }
    }

}