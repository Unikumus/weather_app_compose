package com.example.weather_1.domain.use_case.get_forecast

import com.example.weather_1.data.remoute.dto.week_forecast_dto.toDaily
import com.example.weather_1.data.repository.WeatherRepositoryImpl
import com.example.weather_1.domain.model.Daily
import com.example.weather_1.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

    class GetForecastUseCase @Inject constructor(
    private val api: WeatherRepositoryImpl
    ) {

    operator fun invoke( ): Flow<Resource<List<Daily>>> = flow {
        try {

        emit(Resource.Loading())
        val forecastList = api.getForecast( ).map { it.toDaily() }
        emit(Resource.Success(forecastList))

        } catch (e: HttpException) {
            emit(Resource.Error<List<Daily>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Daily>>("Couldn't reach server. Check your internet connection."))
        }
    }

}