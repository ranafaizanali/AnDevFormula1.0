package com.example.andevformula.m14_responsive_ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun OrientationBasedUIExample() {

    val configuration = LocalConfiguration.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){

        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Text(text = "Landscape UI")
        } else {
            Text(text = "Portrait UI")
        }

    }

}