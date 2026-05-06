package com.example.andevformula.s08_lists

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemsExample() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 40.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        // items(count)
        LazyColumn() {
            items(5) { index ->
                Text("Item $index")
            }
        }

        // items(list)
        val names = listOf("Rahul", "Faizan", "Rohit", "Shubham", "Rajib", "Rockey")
        LazyColumn() {
            items(names) { name ->
                Text(text = name)
            }
        }

        // itemsIndexed(list)
        LazyColumn() {
            itemsIndexed(names) { index, name ->
                Text(text = "${index + 1}: $name")
            }
        }

        LazyColumn() {

            item {
                Text(
                    text = "Heading",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            itemsIndexed(names) { index, name ->
                Text(text = "${index + 1}: $name")
            }

        }

    }

}