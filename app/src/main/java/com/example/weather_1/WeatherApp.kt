package com.example.weather_1

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class WeatherApp : Application()


//@HiltAndroidApp
//
//class WeatherApp : Application() {
//    override fun onCreate() {
//        super.onCreate()
//    }
//
//    private var mCurrentActivity: Activity? = null
//    fun getCurrentActivity(): Activity? {
//        return mCurrentActivity
//    }
//
//    fun setCurrentActivity(mCurrentActivity: Activity?) {
//        this.mCurrentActivity = mCurrentActivity
//    }
//}


//class WeatherApp : Application() {
//    override fun onCreate() {
//        super.onCreate()
//    }
//
//    var currentActivity: Activity? = null
//
//    fun getCurrentActivity(): Activity? {
//        return mCurrentActivity
//    }
//
//    fun setCurrentActivity(mCurrentActivity: Activity) {
//        mCurrentActivity = mCurrentActivity
//    }
//}
