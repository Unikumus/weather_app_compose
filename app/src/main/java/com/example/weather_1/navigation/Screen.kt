package com.example.weather_1.navigation

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object ForecastScreen: Screen("forecast_screen")
}