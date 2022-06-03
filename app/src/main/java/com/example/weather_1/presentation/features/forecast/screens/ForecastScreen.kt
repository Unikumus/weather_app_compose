package com.example.weather_1.presentation.features.forecast.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.weather_1.presentation.features.forecast.ForecastViewModel
import com.example.weather_1.presentation.features.forecast.components.ForecastCard
import com.example.weather_1.presentation.theme.CustomShape
import com.example.weather_1.presentation.theme.circleGradient
import com.example.weather_1.presentation.features.forecast.WeatherState
import com.example.weather_1.presentation.theme.gradient

@Composable
fun ForecastScreen (
    viewModel: ForecastViewModel = hiltViewModel(),
    navigator: NavHostController) {

    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .background(gradient)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ){


        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .height(300.dp)
                .fillMaxWidth()
                .clip(shape = CustomShape())
                .background(circleGradient)
        )


        if(state.isLoading == false )
            ForecastScreenContent(state = state, navigator = navigator)
        else CircularProgressIndicator(color = Color.White)
    }


}

@Composable
fun ForecastScreenContent(state: WeatherState, navigator: NavHostController){
    // Forecast Cards
    LazyColumn(
    ){
        items(state.forecast.size){
            ForecastCard(day =  state.forecast[it])
        }
    }
}