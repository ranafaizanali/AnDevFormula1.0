package com.example.andevformula.s1_text

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ClickableTextExample() {

    Text(
        text = "Click here",
        fontSize = 40.sp,
        modifier = Modifier.clickable(onClick = { })
    )

}