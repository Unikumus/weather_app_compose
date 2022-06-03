package com.example.weather_1.domain.use_case.get_day_forecast

import com.example.weather_1.data.remoute.dto.day_forecast_dto.toHourForecast
import com.example.weather_1.data.repository.WeatherRepositoryImpl
import com.example.weather_1.domain.model.FiveDayForecast
import com.example.weather_1.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetFiveDayForecastUseCase @Inject constructor(
    private val api: WeatherRepositoryImpl
) {

    operator fun invoke( ): Flow<Resource<FiveDayForecast>> = flow {
        try {

            emit(Resource.Loading())
            val forecastList = api.getWeatherFiveDay()
            val resp = FiveDayForecast(
                city = forecastList.city.name,
                list = forecastList.list.map { it.toHourForecast() }
            )

            emit(Resource.Success(resp))

        } catch (e: HttpException) {
            emit(Resource.Error<FiveDayForecast>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<FiveDayForecast>("Couldn't reach server. Check your internet connection."))
        }
    }

}