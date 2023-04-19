package com.example.messager.navegation


import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.messager.Screen.MainScreen
import com.example.messager.data.ChatScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavItem.Main.baseRoute
    ) {
        //navegar desde el main al detail
        composable(NavItem.Main.route) {
            MainScreen( onNavigate = {
                navController.navigate(NavItem.ChatScreen.createRoute(it))
               // Log.d("ruta",NavItem.Detail.createRoute(it))
            })
        }
        //Navegar desde Splash (Logo) a main
        /*composable(NavItem.Splash.route){
            SplashScreen(onNavigate={
                navController.popBackStack()
                navController.navigate(NavItem.Main.route)

            } )
        }*/


        composable(NavItem.ChatScreen) { backStackEntry ->
            ChatScreen(
               // mediaId = backStackEntry.findArg(NavArgs.MediaId),
                //id = backStackEntry.findArg<Int>(NavArgs.Id).toInt(),
               // onUpClick = { navController.popBackStack() }
            )
        }
    }
}

private fun NavGraphBuilder.composable(
    navItem: NavItem,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navItem.route,
        arguments = navItem.args
    ) {
        content(it)
    }
}

private inline fun <reified T> NavBackStackEntry.findArg(args: NavArgs): T {
    val value = arguments?.getInt(args.key)
    requireNotNull(value)
    return value as T
}