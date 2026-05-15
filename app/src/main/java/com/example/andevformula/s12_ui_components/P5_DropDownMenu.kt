package com.example.andevformula.s12_ui_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun DropDownMenuExample() {

    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("Select City") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                expanded = true
            },
            modifier = Modifier.fillMaxWidth(0.4f)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = selectedItem, modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null
                )
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {

            // Delhi , Mumbai, Agra, Hyderabad, Channai

            DropdownMenuItem(
                text = { Text("Delhi") },
                onClick = {
                    selectedItem = "Delhi"
                    expanded = false
                }
            )

            DropdownMenuItem(
                text = { Text("Mumbai") },
                onClick = {
                    selectedItem = "Mumbai"
                    expanded = false }
            )

            DropdownMenuItem(
                text = { Text("Agra") },
                onClick = {
                    selectedItem = "Agra"
                    expanded = false }
            )

            DropdownMenuItem(
                text = { Text("Hyderabad") },
                onClick = {
                    selectedItem = "Hyderabad"
                    expanded = false }
            )

            DropdownMenuItem(
                text = { Text("Channai") },
                onClick = {
                    selectedItem = "Channai"
                    expanded = false }
            )

            DropdownMenuItem(
                text = { Text("Madhya Pradesh") },
                onClick = {
                    selectedItem = "Madhya Pradesh"
                    expanded = false }
            )

            DropdownMenuItem(
                text = { Text("Bhopal") },
                onClick = {
                    selectedItem = "Bhopal"
                    expanded = false }
            )


        }

    }

}