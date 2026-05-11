package com.example.andevformula.s12_ui_components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun SnackBarExample() {

    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val context = LocalContext.current

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackBarHostState)
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    scope.launch {

                        val result = snackBarHostState.showSnackbar(
                            message = "Item has been deleted!",
                            actionLabel = "UNDO",
                            duration = SnackbarDuration.Short
                        )

                        when (result) {

                            SnackbarResult.ActionPerformed -> {
                                Toast.makeText(
                                    context,
                                    "Undo clicked",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            SnackbarResult.Dismissed -> {
                                Toast.makeText(
                                    context,
                                    "SnackBar dismissed",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                    }
                }
            ) {
                Text("Click Me")
            }
        }

    }

}

@Composable
fun TopSnackBarExample() {

    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Button(
            onClick = {
                scope.launch {

                    val result = snackBarHostState.showSnackbar(
                        message = "Item has been deleted!",
                        actionLabel = "UNDO",
                        duration = SnackbarDuration.Short
                    )

                    when (result) {

                        SnackbarResult.ActionPerformed -> {
                            Toast.makeText(
                                context,
                                "Undo clicked",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        SnackbarResult.Dismissed -> {
                            Toast.makeText(
                                context,
                                "SnackBar dismissed",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                }
            }
        ) {
            Text("Click Me")
        }

        SnackbarHost(
            hostState = snackBarHostState,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(16.dp)
        )

    }

}