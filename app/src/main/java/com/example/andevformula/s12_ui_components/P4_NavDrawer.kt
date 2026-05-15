package com.example.andevformula.s12_ui_components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun NavDrawerExample() {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val scope = rememberCoroutineScope()

    val screenNames = listOf(

        ScreenItem("Home", Icons.Default.Home),
        ScreenItem("Profile", Icons.Default.Person),
        ScreenItem("Cart", Icons.Default.ShoppingCart),
        ScreenItem("Settings", Icons.Default.Settings)
    )

    var selectedScreen by remember { mutableStateOf("Home") }

    ModalNavigationDrawer(
        gesturesEnabled = true,
        drawerState = drawerState,
        drawerContent = {

            ModalDrawerSheet(
                drawerContainerColor = Color.White,
                drawerContentColor = Color.DarkGray,
                drawerShape = RoundedCornerShape(
                    topEnd = 24.dp,
                    bottomEnd = 24.dp
                ),
                windowInsets = WindowInsets.safeDrawing,
                modifier = Modifier.fillMaxWidth(0.75f)
//                    .padding(vertical = 24.dp)
            ) {

                Text(
                    text = "AnDev Formula",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )

                HorizontalDivider()

                screenNames.forEach { item ->

                    NavigationDrawerItem(
                        label = { Text(text = item.name) },
                        selected = selectedScreen == item.name,
                        onClick = {
                            selectedScreen = item.name
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name
                            )
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = Color.DarkGray,
                            selectedIconColor = Color.White,
                            selectedTextColor = Color.White
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.padding(
                            horizontal = 12.dp,
                            vertical = 8.dp
                        )
                    )

                }

            }

        }
    ) {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = selectedScreen) },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope
                                    .launch {
                                        if (drawerState.isClosed) {
                                            drawerState.open()
                                        } else {
                                            drawerState.close()
                                        }
                                    }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "$selectedScreen Screen",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )

            }

        }

    }
}

data class ScreenItem(
    val name: String,
    val icon: ImageVector
)