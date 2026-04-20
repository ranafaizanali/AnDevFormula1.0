package com.example.andevformula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.andevformula.s1_text.SelectableTextExample
import com.example.andevformula.s4_buttons.ButtonExample
import com.example.andevformula.s4_buttons.IconButtonExample
import com.example.andevformula.s4_buttons.OutlinedButtonExample
import com.example.andevformula.s4_buttons.TextButtonExample
import com.example.andevformula.s6_dividers.HorizontalDividerExample
import com.example.andevformula.s6_dividers.VerticalDividerExample
import com.example.andevformula.ui.theme.AnDevFormulaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnDevFormulaTheme {

                VerticalDividerExample()

            }
        }
    }
}