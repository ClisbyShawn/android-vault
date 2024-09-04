package com.clisbyshawn.vault.navigation

sealed class MyAppHostScreens(val route: String) {
    data object VaultEntry : MyAppHostScreens(route = VaultEntry::class.java.name)
    data object Vault : MyAppHostScreens(route = Vault::class.java.name)

}