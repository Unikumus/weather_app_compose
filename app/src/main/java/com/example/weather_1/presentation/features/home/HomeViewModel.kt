package com.example.weather_1.presentation.features.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather_1.domain.model.FiveDayForecast
import com.example.weather_1.domain.use_case.get_day_forecast.GetFiveDayForecastUseCase
import com.example.weather_1.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (
    private val getFiveDayForecastUseCase : GetFiveDayForecastUseCase
    ) : ViewModel()  {

    private val _state = mutableStateOf(DayWeatherState())
    val state: State<DayWeatherState> = _state

    init {
        getWeather( )
    }
    private fun getWeather ( ){

        getFiveDayForecastUseCase( ).onEach{ result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = DayWeatherState(forecast = result.data ?: FiveDayForecast())
                }
                is Resource.Error -> {
                    _state.value = DayWeatherState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = DayWeatherState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)

    }

}