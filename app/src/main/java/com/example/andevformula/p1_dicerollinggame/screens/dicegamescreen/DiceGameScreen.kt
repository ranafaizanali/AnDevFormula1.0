package com.example.andevformula.p1_dicerollinggame.screens.dicegamescreen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.andevformula.p1_dicerollinggame.navigation.DiceRoutes
import com.example.andevformula.p1_dicerollinggame.navigation.ScoreImage01
import com.example.andevformula.p1_dicerollinggame.navigation.ScoreImage02
import com.example.andevformula.p1_dicerollinggame.navigation.ScoreImage03
import com.example.andevformula.p1_dicerollinggame.navigation.ScoreImage04
import com.example.andevformula.p1_dicerollinggame.navigation.ScoreImage05
import com.example.andevformula.p1_dicerollinggame.navigation.ScoreImage06
import com.example.andevformula.ui.theme.DiceBlue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun DiceGameScreen(
    player01Name: String,
    player02Name: String,
    totalScore: Int,
    navController: NavHostController
) {

    var player01Score by remember { mutableIntStateOf(0) }
    var player02Score by remember { mutableIntStateOf(0) }

    val playerTurn = (1..2).random()

    var diceValue by remember { mutableIntStateOf(1) }
    var isPlayer1Turn by remember { mutableStateOf(playerTurn == 1) }
    var isRolling by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()

    val rotation = remember { Animatable(0f) }

    Scaffold(
        topBar = { DiceGameTopBar(navController) }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                    contentColor = Color.DarkGray
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = CircleShape,
            ) {

                Text(
                    text = "Target: $totalScore",
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)
                )

            }

            Spacer(modifier = Modifier.height(32.dp))

            Row {

                Card(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isPlayer1Turn) DiceBlue else Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = if (isPlayer1Turn) 6.dp else 2.dp
                    ),
                    border = if (isPlayer1Turn) null else BorderStroke(1.dp, Color.Gray)
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = player01Name,
                            fontWeight = FontWeight.SemiBold,
                            color = if (isPlayer1Turn) Color.White else Color.DarkGray
                        )

                        Text(
                            text = player01Score.toString(),
                            fontSize = 28.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (isPlayer1Turn) Color.White else Color.Gray
                        )

                    }

                }

                Spacer(modifier = Modifier.width(8.dp))

                Card(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isPlayer1Turn) Color.White else DiceBlue
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = if (isPlayer1Turn) 2.dp else 6.dp
                    ),
                    border = if (isPlayer1Turn) BorderStroke(1.dp, Color.Gray) else null
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = player02Name,
                            fontWeight = FontWeight.SemiBold,
                            color = if (isPlayer1Turn) Color.DarkGray else Color.White
                        )

                        Text(
                            text = player02Score.toString(),
                            fontSize = 28.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (isPlayer1Turn) Color.Gray else Color.White
                        )

                    }

                }

            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = if (isPlayer1Turn) "$player01Name's Turn" else "$player02Name's Turn",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(48.dp))

            Card(
                shape = RoundedCornerShape(28.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                border = BorderStroke(1.dp, Color.Gray)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 36.dp)
                        .rotate(rotation.value),
                    horizontalArrangement = Arrangement.Center
                ) {

                    when (diceValue) {
                        1 -> ScoreImage01()
                        2 -> ScoreImage02()
                        3 -> ScoreImage03()
                        4 -> ScoreImage04()
                        5 -> ScoreImage05()
                        else -> ScoreImage06()
                    }

                }

            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Roll a 6 to keep your turn!",
                color = Color.Gray
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                Button(
                    onClick = {

                        if (!isRolling) {
                            isRolling = true
                            scope.launch {

                                repeat(5) {
                                    diceValue = (1..6).random()
                                    rotation.snapTo(0f)
                                    rotation.animateTo(180f, tween(50))
                                    delay(40)
                                }

                                diceValue = (1..6).random()
                                player01Score += diceValue

                                isRolling = false
                                isPlayer1Turn = false

                                if (diceValue == 6) isPlayer1Turn = true

                                if (player01Score >= totalScore) {
                                    navController.navigate(DiceRoutes.Winner(winnerName = player01Name))
                                    return@launch
                                }

                            }
                        }

                    },
                    modifier = Modifier
                        .height(52.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = DiceBlue,
                        contentColor = Color.White
                    ),
                    enabled = isPlayer1Turn
                ) {
                    Text(
                        text = "P1: Roll",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = {

                        if (!isRolling) {
                            isRolling = true
                            scope.launch {

                                repeat(5) {
                                    diceValue = (1..6).random()
                                    rotation.snapTo(0f)
                                    rotation.animateTo(180f, tween(50))
                                    delay(40)
                                }

                                diceValue = (1..6).random()
                                player02Score += diceValue

                                isRolling = false
                                isPlayer1Turn = true

                                if (diceValue == 6) isPlayer1Turn = false

                                if (player02Score >= totalScore) {
                                    navController.navigate(DiceRoutes.Winner(winnerName = player02Name))
                                    return@launch
                                }

                            }
                        }

                    },
                    modifier = Modifier
                        .height(52.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = DiceBlue,
                        contentColor = Color.White
                    ),
                    enabled = !isPlayer1Turn
                ) {
                    Text(
                        text = "P2: Roll",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }

            }

        }

    }

}