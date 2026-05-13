package com.example.andevformula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.andevformula.s12_ui_components.AlertDialogExample
import com.example.andevformula.s12_ui_components.DropDownMenuExample
import com.example.andevformula.s12_ui_components.SnackBarExample
import com.example.andevformula.s12_ui_components.TopSnackBarExample
import com.example.andevformula.s13_navigation_bar.NavBarNavigation
import com.example.andevformula.ui.theme.AnDevFormulaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnDevFormulaTheme {

                NavBarNavigation()

            }
        }
    }
}