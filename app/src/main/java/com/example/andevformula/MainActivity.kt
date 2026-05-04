package com.example.andevformula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.andevformula.s7_scaffold.BottomBarExample
import com.example.andevformula.s7_scaffold.FABExample
import com.example.andevformula.s7_scaffold.ScaffoldExample
import com.example.andevformula.s7_scaffold.TopBarExample
import com.example.andevformula.s8_lists.ItemsExample
import com.example.andevformula.s8_lists.LazyColumnExample
import com.example.andevformula.s8_lists.LazyRowExample
import com.example.andevformula.s8_lists.MixedLayoutsExample
import com.example.andevformula.ui.theme.AnDevFormulaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnDevFormulaTheme {

                MixedLayoutsExample()

            }
        }
    }
}