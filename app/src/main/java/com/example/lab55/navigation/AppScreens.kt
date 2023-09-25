package com.example.lab55.navigation

sealed class AppScreens(val route: String){
    object MainActivity: AppScreens("first_screen")
    object EventDetailsActivity: AppScreens("second_screen")
}
