package com.example.andevformula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.andevformula.s5_cards.CardExample
import com.example.andevformula.s5_cards.ProfileCard
import com.example.andevformula.s6_dividers.VerticalDividerExample
import com.example.andevformula.s7_scaffold.FABExample
import com.example.andevformula.ui.theme.AnDevFormulaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnDevFormulaTheme {

                FABExample()

            }
        }
    }
}