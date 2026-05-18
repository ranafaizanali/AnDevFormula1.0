package com.example.andevformula.p1_dice_rolling_game.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.andevformula.p1_dice_rolling_game.screens.dicegamescreen.DiceGameScreen
import com.example.andevformula.p1_dice_rolling_game.screens.playersnamescreen.PlayersNameScreen
import com.example.andevformula.p1_dice_rolling_game.screens.winnerscreen.WinnerScreen

@Composable
fun DiceNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = DiceRoutes.PlayersName
    ) {

        composable<DiceRoutes.PlayersName> {
            PlayersNameScreen(navController = navController)
        }

        composable<DiceRoutes.DiceGame> { backStackEntry ->
            val args = backStackEntry.toRoute<DiceRoutes.DiceGame>()
            DiceGameScreen(
                player01Name = args.player01,
                player02Name = args.player02,
                totalScore = args.totalScore,
                navController = navController
            )
        }

        composable<DiceRoutes.Winner> { backStackEntry ->
            val args = backStackEntry.toRoute<DiceRoutes.Winner>()
            WinnerScreen(
                winnerName = args.winnerName,
                navController = navController
            )
        }

    }

}