package com.example.weather_1.presentation.features.home.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.weather_1.R
import com.example.weather_1.common.Constants.Companion.ICON_PATH
import com.example.weather_1.common.components.AppButton
import com.example.weather_1.navigation.Screen
import com.example.weather_1.presentation.features.home.DayWeatherState
import com.example.weather_1.presentation.features.home.HomeViewModel
import com.example.weather_1.presentation.features.home.components.AppBar
import com.example.weather_1.presentation.features.home.components.InfoRow
import com.example.weather_1.presentation.features.home.components.TempColumn
import com.example.weather_1.presentation.theme.CustomShape
import com.example.weather_1.presentation.theme.circleGradient
import com.example.weather_1.presentation.theme.gradient


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigator: NavHostController
) {

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
        ScreenContent(state = state, navigator = navigator) else CircularProgressIndicator(color = Color.White)
    }


}



@Composable
fun ScreenContent(state: DayWeatherState, navigator: NavHostController) {


    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp,),
    ){
        AppBar(
            date = state.forecast.list[0].date,
            time = state.forecast.list[0].time,
            location = state.forecast.city
        )

        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = rememberImagePainter(
                "$ICON_PATH${state.forecast.list[0].weather[0].icon}@4x.png"),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )

        // current temperature
        Text(
            text = buildAnnotatedString {
                append(
                    AnnotatedString(
                        state.forecast.list[0].temperature,
                        spanStyle = SpanStyle(
                            Color.White,
                            fontSize = 64.sp,
                            fontWeight = FontWeight.Black,
                        )
                    )
                )

                append(
                    AnnotatedString(
                        "°С",
                        spanStyle = SpanStyle(
                            Color.White,
                            fontSize = 24.sp,
                            baselineShift = BaselineShift(2f)
                        )
                    )
                )
            },
            modifier = Modifier.padding(top = 20.dp)

        )

        InfoRow(state = state)
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            TempColumn(day = state.forecast.list[1])
            TempColumn(day = state.forecast.list[2])
            TempColumn(day = state.forecast.list[3])
            TempColumn(day = state.forecast.list[4])
            TempColumn(day = state.forecast.list[5])
        }

        Spacer(modifier = Modifier.height(20.dp))
        AppButton(
            text = stringResource(id = R.string.seven_day_forecast),
            onClick =  { navigator.navigate(Screen.ForecastScreen.route) },
        )
        Spacer(modifier = Modifier.height(40.dp))


    }
}



