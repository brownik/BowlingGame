package com.brownik.bowling_game.common_base.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel

abstract class BaseViewModel(
    private val app: Application,
) : AndroidViewModel(app) {
    protected val applicationContext: Context
        get() = app.applicationContext
}