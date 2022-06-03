package com.example.weather_1.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.weather_1.navigation.MainNavigation
import com.example.weather_1.presentation.theme.Weather_1Theme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity() : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme{
                MainNavigation()
            }
        }
    }

}

@Composable
fun MainTheme(content: @Composable () -> Unit) {
    Weather_1Theme {
        Surface(
            color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_3)
@Composable
fun DefaultPreview() {
    MainTheme{

    }
}




