package com.example.andevformula.s1_text

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun BasicTextFieldExample() {

    var username by remember { mutableStateOf("") }

    BasicTextField(
        value = username,
        onValueChange = { username = it }
    )

}