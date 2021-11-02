package com.plcoding.cryptocurrencyappyt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/*The application class gives Hilt the info about out application
* so that Hilt also has access to the application context if we
* need that for our dependencies*/

@HiltAndroidApp
class CoinApplication :Application(){

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}