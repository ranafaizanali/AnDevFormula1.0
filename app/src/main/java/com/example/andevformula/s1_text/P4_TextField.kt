package com.example.andevformula.s1_text

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextFieldExample() {

    var username by remember { mutableStateOf("") }

    TextField(
        value = username,
        onValueChange = { username = it },
        // label = { Text(text = "Username") },
        placeholder = { Text(text = "Username") },
        leadingIcon = { Text(text = "#", fontSize = 20.sp) },
        trailingIcon = { Text(text = "*", fontSize = 20.sp) },
        maxLines = 1,
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Gray,
            focusedContainerColor = Color.Gray,
            focusedPlaceholderColor = Color.White,
            unfocusedPlaceholderColor = Color.White,
            focusedLeadingIconColor = Color.Green,
            unfocusedLeadingIconColor = Color.Red,
            focusedTrailingIconColor = Color.Green,
            unfocusedTrailingIconColor = Color.Red,
            unfocusedIndicatorColor = Color.Red,
            focusedIndicatorColor = Color.Green
        )
    )

}