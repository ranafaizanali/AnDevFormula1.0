package com.example.andevformula.s3_images_icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.andevformula.R

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ImageExample() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(R.drawable.icon),
            contentDescription = "ToDo App Icon",
            modifier = Modifier
                .width(300.dp)
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        
    }

}