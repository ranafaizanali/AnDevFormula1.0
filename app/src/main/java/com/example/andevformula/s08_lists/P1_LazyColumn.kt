package com.example.andevformula.s08_lists

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LazyColumnExample() {

//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(32.dp)
//    ) {
//
//        for (i in 1..10) {
//            Text(
//                text = "Text #$i",
//                fontSize = 20.sp
//            )
//        }
//    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        items(20) { index ->

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Text("Box $index")
            }

        }

    }

}