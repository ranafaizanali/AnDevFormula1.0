package com.example.andevformula.m11_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.andevformula.m11_navigation.screens.NavDetailsScreen
import com.example.andevformula.m11_navigation.screens.NavHomeScreen
import com.example.andevformula.m11_navigation.screens.NavLoginScreen
import com.example.andevformula.m11_navigation.screens.NavWelcomeScreen

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

        composable<NavRoutes.NavLogin> {
            NavLoginScreen(navController)
        }

        composable<NavRoutes.NavWelcome> { backStackEntry ->
            val args = backStackEntry.toRoute<NavRoutes.NavWelcome>()
            NavWelcomeScreen(navController, username = args.name)
        }

    }

}