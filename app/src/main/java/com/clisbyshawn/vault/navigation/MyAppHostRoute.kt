package com.clisbyshawn.vault.navigation

sealed class MyAppHostRoute(val route: String) {
    data object VaultEntry : MyAppHostRoute(route = VaultEntry::class.java.name)
    data object Vault : MyAppHostRoute(route = Vault::class.java.name)

}