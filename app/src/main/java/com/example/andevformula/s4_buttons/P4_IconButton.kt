package com.example.andevformula.s4_buttons

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun IconButtonExample() {

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        IconButton(
            onClick = {
                Toast.makeText(
                    context,
                    "IconButton Clicked!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "Lock Icon"
            )
        }

        IconButton(
            onClick = {
                Toast.makeText(
                    context,
                    "IconButton Clicked!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "Lock Icon"
            )
        }

        Icon(
            imageVector = Icons.Default.Lock,
            contentDescription = "Lock Icon",
            modifier = Modifier.clickable(
                onClick = {
                    Toast.makeText(
                        context,
                        "Icon Clicked!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )
        )

        Icon(
            imageVector = Icons.Default.Lock,
            contentDescription = "Lock Icon",
            modifier = Modifier.clickable(
                onClick = {
                    Toast.makeText(
                        context,
                        "Icon Clicked!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )
        )

    }

}