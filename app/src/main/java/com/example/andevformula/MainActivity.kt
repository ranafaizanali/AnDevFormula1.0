package com.example.andevformula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.andevformula.p1_dicerollinggame.navigation.DiceNavigation
import com.example.andevformula.p2_tictactoegame.ui.TicTacToeGame
import com.example.andevformula.p2_tictactoegame.viewmodel.GameViewModel
import com.example.andevformula.ui.theme.AnDevFormulaTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<GameViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnDevFormulaTheme {

                TicTacToeGame(viewModel)

            }
        }
    }
}