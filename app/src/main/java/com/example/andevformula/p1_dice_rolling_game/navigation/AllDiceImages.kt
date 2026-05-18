package com.example.andevformula.p1_dice_rolling_game.navigation

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.andevformula.R

@Composable
fun ScoreImage01() {

    Image(
        painter = painterResource(R.drawable.dice_01),
        contentDescription = "1 Point"
    )

}

@Composable
fun ScoreImage02() {

    Image(
        painter = painterResource(R.drawable.dice_02),
        contentDescription = "2 Point"
    )

}

@Composable
fun ScoreImage03() {

    Image(
        painter = painterResource(R.drawable.dice_03),
        contentDescription = "3 Point"
    )

}

@Composable
fun ScoreImage04() {

    Image(
        painter = painterResource(R.drawable.dice_04),
        contentDescription = "4 Point"
    )

}

@Composable
fun ScoreImage05() {

    Image(
        painter = painterResource(R.drawable.dice_05),
        contentDescription = "5 Point"
    )

}

@Composable
fun ScoreImage06() {

    Image(
        painter = painterResource(R.drawable.dice_06),
        contentDescription = "6 Point"
    )

}