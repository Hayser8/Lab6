package com.example.lab55.navigation

import EventDetails
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lab55.MainActivity
import com.example.lab55.TodoEventoApp
import com.example.lab55.ui.events.model.EventContent

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MainActivity.route){
        composable(route = AppScreens.MainActivity.route){
            TodoEventoApp(navController)
        }
        composable(route = AppScreens.EventDetailsActivity.route + "/{mediaId}",
        arguments = listOf(navArgument(name = "mediaId"){
            type = NavType.StringType
        })){ backStackEntry ->
            val id = backStackEntry.arguments?.getString("mediaId")
            requireNotNull(id)
            EventDetails(navController, id, EventContent.events)
        }
    }
}