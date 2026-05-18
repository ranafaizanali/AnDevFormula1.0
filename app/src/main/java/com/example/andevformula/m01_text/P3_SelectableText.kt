package com.example.andevformula.m01_text

import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun SelectableTextExample() {

    SelectionContainer {

        Text(
            text = "Hello, World!\nHello,\nWorld! Hello,\nWorld! Hello, World!",
            fontSize = 30.sp
        )

    }

}