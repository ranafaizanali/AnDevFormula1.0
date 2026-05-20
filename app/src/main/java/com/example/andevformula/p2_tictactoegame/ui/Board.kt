package com.example.andevformula.p2_tictactoegame.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.andevformula.p2_tictactoegame.data.CellState

@Composable
fun Board(
    board: List<MutableList<CellState>>,
    winningCells: List<Pair<Int, Int>>,
    onCellClick: (row: Int, col: Int) -> Unit
) {

    val screenWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val side = (screenWidthDp - 64.dp).coerceAtMost(380.dp)

    Column(
        modifier = Modifier
            .size(side)
            .clip(RoundedCornerShape(20.dp))
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        for (r in 0..2) {

            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                for (c in 0..2) {

                    Cell(
                        state = board[r][c],
                        onClick = { onCellClick(r, c) },
                        highlight = winningCells.contains(Pair(r, c)),
                        modifier = Modifier.weight(1f)
                    )

                }

            }

        }

    }

}