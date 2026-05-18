package com.example.andevformula.m13_navigation_bar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.andevformula.m13_navigation_bar.screens.NavBarHomeScreen
import com.example.andevformula.m13_navigation_bar.screens.NavBarProfileScreen
import com.example.andevformula.m13_navigation_bar.screens.NavBarSearchScreen

@Composable
fun NavBarNavigation() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val selectedRoute: NavBarRoutes = when {
        currentDestination?.hasRoute(NavBarRoutes.NavBarSearch::class) == true -> NavBarRoutes.NavBarSearch
        currentDestination?.hasRoute(NavBarRoutes.NavBarProfile::class) == true -> NavBarRoutes.NavBarProfile
        else -> NavBarRoutes.NavBarHome
    }

    Scaffold(
        bottomBar = {
            BottomBar(
                selectedItem = selectedRoute,
                onItemClick = { route ->
                    navController.navigate(route){
                        popUpTo(NavBarRoutes.NavBarHome){
                            inclusive = false
                        }
                        launchSingleTop = true
                    }
                }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = NavBarRoutes.NavBarHome,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable<NavBarRoutes.NavBarHome> {
                NavBarHomeScreen()
            }

            composable<NavBarRoutes.NavBarSearch> {
                NavBarSearchScreen()
            }

            composable<NavBarRoutes.NavBarProfile> {
                NavBarProfileScreen()
            }

        }

    }

}