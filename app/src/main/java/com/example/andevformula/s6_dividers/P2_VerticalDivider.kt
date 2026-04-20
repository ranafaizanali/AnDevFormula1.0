package com.example.andevformula.s6_dividers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun VerticalDividerExample() {

    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "Faizan Ali\nFaizan Ali\nFaizan Ali\nFaizan Ali",
            fontSize = 24.sp
        )

        VerticalDivider(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .height(100.dp),
            thickness = 1.dp,
            color = Color.Gray
        )

        Text(
            text = "Faizan Ali\nFaizan Ali\nFaizan Ali\nFaizan Ali",
            fontSize = 24.sp
        )

    }

}