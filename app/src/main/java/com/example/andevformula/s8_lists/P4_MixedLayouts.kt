package com.example.andevformula.s8_lists

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MixedLayoutsExample() {

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(vertical = 32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        items(20) { index ->

            Column() {

                Text(
                    text = "Row No.${index + 1}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {

                    items(10) { index ->
                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .background(
                                    color = Color.Gray,
                                    shape = RoundedCornerShape(8.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Box No. ${index + 1}")
                        }
                    }

                }

            }

        }

    }

}