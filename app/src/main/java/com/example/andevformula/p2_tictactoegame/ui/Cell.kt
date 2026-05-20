package com.example.andevformula.p2_tictactoegame.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andevformula.p2_tictactoegame.data.CellState

@Composable
fun Cell(
    state: CellState,
    onClick: () -> Unit,
    highlight: Boolean,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
            .aspectRatio(1f)
            .padding(6.dp)
            .clickable(enabled = state == CellState.EMPTY) { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = if (highlight) Color.LightGray else Color.White
        ),
        border = BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.75f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = when (state) {
                    CellState.X -> "X"
                    CellState.O -> "O"
                    else -> ""
                },
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = when (state) {
                    CellState.X -> Color.Black
                    CellState.O -> Color.Black.copy(alpha = 0.5f)
                    else -> Color.Black
                }
            )

        }

    }

}