package com.example.weather_1.presentation.features.forecast.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.weather_1.presentation.features.forecast.ForecastViewModel
import com.example.weather_1.presentation.features.forecast.WeatherState
import com.example.weather_1.presentation.features.forecast.components.ForecastCard
import com.example.weather_1.presentation.theme.CustomShape
import com.example.weather_1.presentation.theme.circleGradient
import com.example.weather_1.presentation.theme.gradient
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ForecastScreen(
    viewModel: ForecastViewModel = hiltViewModel(),
    navigator: NavHostController
) {

    val state = viewModel.state.value

    val sheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )

    val scope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetBackgroundColor = Color.White,
        sheetPeekHeight = 0.dp,
        sheetContent = {
            SheetContent()
        }) {
        Box(
            modifier = Modifier
                .background(gradient)
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {


            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopCenter)
                    .height(300.dp)
                    .fillMaxWidth()
                    .clip(shape = CustomShape())
                    .background(circleGradient)
            )


            if (state.isLoading == false)
                ForecastScreenContent(
                    state = state,
                    navigator = navigator,
                    onClick = {
                        scope.launch {
                            sheetState.expand();
                        }

                    }
                )
            else CircularProgressIndicator(color = Color.White)
        }

    }


}

@Composable
fun ForecastScreenContent(
    state: WeatherState,
    navigator: NavHostController,
    onClick: () -> Unit
) {
    // Forecast Cards
    LazyColumn(
    ) {
        items(state.forecast.size) {
            ForecastCard(day = state.forecast[it], onClick = onClick)
        }
    }
}


@Composable
fun SheetContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .height(100.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Bottom sheet")
    }
}