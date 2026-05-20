package com.example.andevformula.p2_tictactoegame.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.andevformula.p2_tictactoegame.data.CellState
import com.example.andevformula.p2_tictactoegame.data.GameStatus
import com.example.andevformula.p2_tictactoegame.data.Player

class GameViewModel : ViewModel() {

    var board = mutableStateListOf(
        mutableStateListOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY),
        mutableStateListOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY),
        mutableStateListOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY)
    )
        private set

    var currentPlayer = mutableStateOf(Player.X)
        private set

    var message = mutableStateOf("Turn: X")
        private set

    var status = mutableStateOf(GameStatus.ONGOING)
        private set

    var winningCells = mutableStateListOf<Pair<Int, Int>>()
        private set

    fun makeMove(row: Int, col: Int) {

        if (status.value != GameStatus.ONGOING) return
        if (board[row][col] != CellState.EMPTY) return

        board[row][col] = if (currentPlayer.value == Player.X) CellState.X else CellState.O

        currentPlayer.value = if (currentPlayer.value == Player.X) Player.O else Player.X

        message.value = "Turn: ${currentPlayer.value.name}"

        val winner = checkWinner()
        if (winner != null) {
            status.value = if (winner == Player.X) GameStatus.X_WON else GameStatus.O_WON
            message.value = "Player ${winner.name} Won!"
            return
        }

        val draw = isBoardFull()
        if (draw) {
            status.value = GameStatus.DRAW
            message.value = "It's a Draw!"
            return
        }

    }

    fun restartGame() {

        for (r in 0..2) {
            for (c in 0..2) {
                board[r][c] = CellState.EMPTY
            }
        }

        currentPlayer.value = Player.X
        status.value = GameStatus.ONGOING
        message.value = "Turn: X"
        winningCells.clear()

    }

    private fun checkWinner(): Player? {

        // Check Rows
        for (r in 0..2) {
            if (board[r][0] != CellState.EMPTY && board[r][0] == board[r][1] && board[r][1] == board[r][2]) {
                winningCells.addAll(listOf(Pair(r, 0), Pair(r, 1), Pair(r, 2)))
                return if (board[r][0] == CellState.X) Player.X else Player.O
            }
        }

        // Check Columns
        for (c in 0..2) {
            if (board[0][c] != CellState.EMPTY && board[0][c] == board[1][c] && board[1][c] == board[2][c]) {
                winningCells.addAll(listOf(Pair(0, c), Pair(1, c), Pair(2, c)))
                return if (board[0][c] == CellState.X) Player.X else Player.O
            }
        }

        // Check Diagonal 01
        if (board[0][0] != CellState.EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            winningCells.addAll(listOf(Pair(0, 0), Pair(1, 1), Pair(2, 2)))
            return if (board[0][0] == CellState.X) Player.X else Player.O
        }

        // Check Diagonal 02
        if (board[0][2] != CellState.EMPTY && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            winningCells.addAll(listOf(Pair(0, 2), Pair(1, 1), Pair(2, 0)))
            return if (board[0][2] == CellState.X) Player.X else Player.O
        }

        return null

    }

    private fun isBoardFull(): Boolean {

        return board.all { row ->
            row.all { cell ->
                cell != CellState.EMPTY
            }
        }

    }

}