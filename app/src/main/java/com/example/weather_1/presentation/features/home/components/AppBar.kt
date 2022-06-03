package com.example.weather_1.presentation.features.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun AppBar(
    date: String,
    time: String,
    location: String) {

        Row (
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ){

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Text(
                    text = "$date | $time",
                    color = Color.White,
                    fontSize = 12.sp,
                )
                Text(
                    text = location,
                    color = Color.White,
                    fontSize = 16.sp,
                )
            }


        }



}
