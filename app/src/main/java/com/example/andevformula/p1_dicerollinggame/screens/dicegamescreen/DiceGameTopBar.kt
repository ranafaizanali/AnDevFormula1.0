package com.example.andevformula.p1_dicerollinggame.screens.dicegamescreen

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.andevformula.p1_dicerollinggame.navigation.DiceRoutes
import com.example.andevformula.ui.theme.DiceBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiceGameTopBar(navController: NavHostController) {

    TopAppBar(
        title = {
            Text(
                text = "Dice Rolling Game",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = DiceBlue,
            titleContentColor = Color.White
        ),
        actions = {
            Button(
                onClick = { navController.navigate(DiceRoutes.PlayersName) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = DiceBlue
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .padding(end = 16.dp)
                    .height(44.dp)
            ) {
                Text(
                    text = "NEW GAME",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    )

}