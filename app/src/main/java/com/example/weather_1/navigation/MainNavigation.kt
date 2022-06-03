package com.example.weather_1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weather_1.presentation.features.forecast.screens.ForecastScreen
import com.example.weather_1.presentation.features.home.screens.HomeScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {

        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(navigator = navController)
        }

        composable(
            route = Screen.ForecastScreen.route
        ) {
            ForecastScreen(navigator = navController)
        }

    }
}