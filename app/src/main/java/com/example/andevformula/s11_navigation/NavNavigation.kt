package com.example.andevformula.s11_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.andevformula.s11_navigation.screens.NavDetailsScreen
import com.example.andevformula.s11_navigation.screens.NavHomeScreen

@Composable
fun NavNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.NavHome
    ) {

        composable<NavRoutes.NavHome> {
            NavHomeScreen(navController)
        }

        composable<NavRoutes.NavDetails> {
            NavDetailsScreen(navController)
        }

    }

}