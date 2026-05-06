package com.example.andevformula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.andevformula.s8_lists.LazyHorizontalGridExample
import com.example.andevformula.s8_lists.LazyVerticalGridExample
import com.example.andevformula.s8_lists.MixedLayoutsExample
import com.example.andevformula.s9_state_management.ParentComposable
import com.example.andevformula.s9_state_management.SaveStateExample
import com.example.andevformula.s9_state_management.StateManagementExample
import com.example.andevformula.ui.theme.AnDevFormulaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnDevFormulaTheme {

                ParentComposable()

            }
        }
    }
}