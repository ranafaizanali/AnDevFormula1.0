package com.example.andevformula.s11_navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavRoutes {

    @Serializable
    object NavHome : NavRoutes()

    @Serializable
    object NavDetails : NavRoutes()

}