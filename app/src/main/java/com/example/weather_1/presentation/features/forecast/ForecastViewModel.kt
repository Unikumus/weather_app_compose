package com.example.weather_1.presentation.features.forecast

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather_1.domain.use_case.get_forecast.GetForecastUseCase
import com.example.weather_1.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val getForecastUseCase : GetForecastUseCase
) : ViewModel()  {

    private val _state = mutableStateOf(WeatherState())
    val state: State<WeatherState> = _state

    init {
        getWeather( )
    }
    private fun getWeather ( ){

        getForecastUseCase( ).onEach{ result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = WeatherState(forecast = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = WeatherState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = WeatherState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)

    }
}