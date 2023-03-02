package com.brownik.bowling_game.common_util.util

import android.util.Log
import com.brownik.bowling_game.common_util.BuildConfig

object BaseLog {

    private var IS_DEBUG = BuildConfig.DEBUG

    fun e(TAG : String, MSG : String) = run { takeIf { IS_DEBUG }?.let { Log.e(TAG, MSG) } }
    fun i(TAG : String, MSG : String) = run { takeIf { IS_DEBUG }?.let { Log.i(TAG, MSG) } }
    fun w(TAG : String, MSG : String) = run { takeIf { IS_DEBUG }?.let { Log.w(TAG, MSG) } }
    fun v(TAG : String, MSG : String) = run { takeIf { IS_DEBUG }?.let { Log.v(TAG, MSG) } }
    fun d(TAG : String, MSG : String) = run { takeIf { IS_DEBUG }?.let { Log.d(TAG, MSG) } }
}