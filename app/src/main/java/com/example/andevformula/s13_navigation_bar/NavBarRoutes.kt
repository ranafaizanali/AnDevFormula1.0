package com.example.andevformula.s13_navigation_bar

import kotlinx.serialization.Serializable

@Serializable
sealed class NavBarRoutes {

    @Serializable
    object NavBarHome : NavBarRoutes()

    @Serializable
    object NavBarSearch : NavBarRoutes()

    @Serializable
    object NavBarProfile : NavBarRoutes()
}