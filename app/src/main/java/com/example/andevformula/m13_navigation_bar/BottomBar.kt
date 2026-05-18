package com.example.andevformula.m13_navigation_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun BottomBar(
    selectedItem: NavBarRoutes,
    onItemClick: (NavBarRoutes) -> Unit
) {

    val items = listOf(

        BottomBarItem(
            title = "Home",
            icon = Icons.Default.Home,
            routes = NavBarRoutes.NavBarHome
        ),

        BottomBarItem(
            title = "Search",
            icon = Icons.Default.Search,
            routes = NavBarRoutes.NavBarSearch
        ),

        BottomBarItem(
            title = "Profile",
            icon = Icons.Default.Person,
            routes = NavBarRoutes.NavBarProfile
        )

    )

    NavigationBar {

        items.forEach { item ->

            NavigationBarItem(
                selected = selectedItem == item.routes,
                onClick = { onItemClick(item.routes) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title) },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedTextColor = Color.Blue,
                    selectedIconColor = Color.Blue,
                    indicatorColor = Color.Blue.copy(alpha = 0.15f),
                    unselectedTextColor = Color.Gray,
                    unselectedIconColor = Color.Gray
                )
            )

        }

    }

}

data class BottomBarItem(
    val title: String,
    val icon: ImageVector,
    val routes: NavBarRoutes
)