package com.example.andevformula.s4_buttons

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextButtonExample() {

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextButton(
            onClick = {
                Toast.makeText(
                    context,
                    "TextButton Clicked!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            Text(text = "Text Button")
        }

        TextButton(
            onClick = {
                Toast.makeText(
                    context,
                    "TextButton Clicked!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            Text(text = "Text Button")
        }

        Text(
            text = "Clickable Text",
            modifier = Modifier.clickable(
                onClick = {
                    Toast.makeText(
                        context,
                        "Text Clicked!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )
        )
        Text(
            text = "Clickable Text",
            modifier = Modifier.clickable(
                onClick = {
                    Toast.makeText(
                        context,
                        "Text Clicked!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )

        )

    }

}