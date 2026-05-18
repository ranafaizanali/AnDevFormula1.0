package com.example.andevformula.p1_dice_rolling_game.screens.playersnamescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.andevformula.R
import com.example.andevformula.p1_dice_rolling_game.navigation.DiceRoutes
import com.example.andevformula.ui.theme.DiceBlue

@Composable
fun PlayersNameScreen(navController: NavHostController) {

    var player01 by remember { mutableStateOf("") }
    var player02 by remember { mutableStateOf("") }

    var selectedScore by remember { mutableIntStateOf(50) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            shape = RoundedCornerShape(28.dp)
        ) {

            Image(
                painter = painterResource(R.drawable.dice_logo),
                contentDescription = "Game Logo",
                modifier = Modifier
                    .padding(16.dp)
                    .size(160.dp)
            )

        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Dice Roller",
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Add player names & pick a target score",
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = player01,
            onValueChange = { if (it.length <= 8) player01 = it },
            label = { Text("Player 01 Name") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.DarkGray,
                focusedTextColor = DiceBlue,
                unfocusedLabelColor = Color.DarkGray,
                focusedLabelColor = DiceBlue,
                cursorColor = DiceBlue,
                unfocusedBorderColor = Color.DarkGray,
                focusedBorderColor = DiceBlue,
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = player02,
            onValueChange = { if (it.length <= 8) player02 = it },
            label = { Text("Player 02 Name") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.DarkGray,
                focusedTextColor = DiceBlue,
                unfocusedLabelColor = Color.DarkGray,
                focusedLabelColor = DiceBlue,
                cursorColor = DiceBlue,
                unfocusedBorderColor = Color.DarkGray,
                focusedBorderColor = DiceBlue,
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {

            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)
            ) {

                Text(
                    text = "Target Score",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row() {

                    Box(
                        modifier = Modifier
                            .height(48.dp)
                            .weight(1f)
                            .background(
                                color = if (selectedScore == 50) DiceBlue else Color.LightGray,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .clickable(onClick = { selectedScore = 50 }),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "50",
                            color = if (selectedScore == 50) Color.White else Color.DarkGray,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Box(
                        modifier = Modifier
                            .height(48.dp)
                            .weight(1f)
                            .background(
                                color = if (selectedScore == 100) DiceBlue else Color.LightGray,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .clickable(onClick = { selectedScore = 100 }),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "100",
                            color = if (selectedScore == 100) Color.White else Color.DarkGray,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                }

            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                navController.navigate(
                    DiceRoutes.DiceGame(
                        player01 = player01,
                        player02 = player02,
                        totalScore = selectedScore
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = DiceBlue,
                contentColor = Color.White
            ),
            enabled = player01.isNotBlank() && player02.isNotBlank() && player01 != player02,
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "START GAME",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }

}