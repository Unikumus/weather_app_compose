package com.example.weather_1.di

import com.example.weather_1.common.Constants.Companion.BASE_URL
import com.example.weather_1.common.service.GpsTrackerMock
import com.example.weather_1.data.remoute.WeatherApi
import com.example.weather_1.data.repository.WeatherRepositoryImpl
import com.example.weather_1.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideWeatherApi(): WeatherApi {
       return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    @Singleton
    @Provides
    fun provideMainRepository(
        api: WeatherApi,
        gpsTracker: GpsTrackerMock
    ): WeatherRepository {
        return  WeatherRepositoryImpl(
            api = api,
            gpsTracker = gpsTracker)
    }


    @Singleton
    @Provides
    fun provideGpsTracker(
    ): GpsTrackerMock {
        return GpsTrackerMock()
    }

}
