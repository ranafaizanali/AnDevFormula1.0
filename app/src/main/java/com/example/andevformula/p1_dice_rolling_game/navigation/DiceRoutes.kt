package com.example.andevformula.p1_dice_rolling_game.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class DiceRoutes {

    @Serializable
    object PlayersName : DiceRoutes()

    @Serializable
    data class DiceGame(
        val player01: String,
        val player02: String,
        val totalScore: Int
    ) : DiceRoutes()

    @Serializable
    data class Winner(val winnerName: String) : DiceRoutes()
}