package com.example.andevformula.s2_layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun BoxExample() {

    Box(
        modifier = Modifier
            .width(200.dp)
            .height(400.dp)
            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(16.dp)
            )
    ) {

        Text(
            text = "Value 01",
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.Center)
        )

        Text(
            text = "Value 02",
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.BottomStart)
        )

        Text(
            text = "Value 03",
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.TopEnd)
        )

    }

}