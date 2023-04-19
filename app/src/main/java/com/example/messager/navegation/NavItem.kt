package com.example.messager.navegation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavItem(
    internal val baseRoute: String,
    private val navArgs: List<NavArgs> = emptyList()
) {
    object Splash : NavItem("Splash_screen")
    object Main : NavItem("main")

    object ChatScreen : NavItem("Chat",listOf(NavArgs.Id)
    ) {
        fun createRoute(Id: String) = "$baseRoute/$Id"
        //fun createRoute(detailItem: DetailItem) = "$baseRoute/$detailItem"
    }

    val route = run {
        val argValues = navArgs.map { "{${it.key}}" }
        listOf(baseRoute)
            .plus(argValues)
            .joinToString("/")
    }

    val args = navArgs.map {
        navArgument(it.key) { type = it.navType }
    }

}

enum class NavArgs(val key: String, val navType: NavType<*>) {
   // MediaId("mediaId", NavType.IntType),
    Id("id", NavType.StringType),
    //Icono("icono", NavType.inferFromValueType(ImageVector)),
   // Nombre("Nombre", NavType.StringType)
    }