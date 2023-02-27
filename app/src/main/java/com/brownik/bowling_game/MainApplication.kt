package com.brownik.bowling_game

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.brownik.bowling_game.common_util.util.AppConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : MultiDexApplication(){
    companion object {
        private var TAG = MainApplication::class.java.simpleName
        private var instance: MainApplication? = null
        val applicationContext: Context get() = instance!!.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        AppConfig.init(applicationContext)
    }
}