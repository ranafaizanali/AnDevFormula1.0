package com.example.andevformula.p2_tictactoegame.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.coerceIn
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andevformula.p2_tictactoegame.viewmodel.GameViewModel

@Composable
fun TicTacToeGame(viewModel: GameViewModel) {

    val screenWithDp = LocalConfiguration.current.screenWidthDp.dp
    val sidePad = (screenWithDp * 0.06f).coerceIn(16.dp, 32.dp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = sidePad, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = "Tic Tac Toe",
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 4.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = viewModel.message.value,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

        }

        Board(
            board = viewModel.board,
            winningCells = viewModel.winningCells,
            onCellClick = { r, c -> viewModel.makeMove(r, c) }
        )

        Button(
            onClick = { viewModel.restartGame() },
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = 480.dp)
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Restart",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 1.sp
            )
        }

    }

}