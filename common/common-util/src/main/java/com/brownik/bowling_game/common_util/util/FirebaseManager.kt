package com.brownik.bowling_game.common_util.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import androidx.core.content.edit
import com.brownik.bowling_game.common_util.R
import com.brownik.bowling_game.common_util.constants.NotificationConstants
import com.brownik.bowling_game.common_util.util.preference.PreferenceUtil
import com.brownik.bowling_game.common_util.util.preference.PreferencesFactory
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.messaging.FirebaseMessaging
import javax.inject.Inject

class FirebaseManager @Inject constructor(
    val firebaseAnalytics: FirebaseAnalytics,
) {

    companion object {
        // Crashlytics custom keys
        private const val CRASHLYTICS_KEY_MEM_NO = "MEM_NO"
        private const val CRASHLYTICS_KEY_GCCV = "GCCV"
        private const val CRASHLYTICS_KEY_APP_STATE = "APP_STATE"
        const val CRASHLYTICS_VAL_BACKGROUND = "background"
        const val CRASHLYTICS_VAL_FOREGROUND = "foreground"
    }

    fun init(context: Context) {
        FirebaseApp.initializeApp(context)
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val preference = PreferencesFactory.getPreferences(context)
                preference.edit {
                    putString(PreferenceUtil.PROPERTY_PUSHKEY_TOKEN, task.result)
                }

                BaseLog.i(this::class.java.simpleName, "푸시 토큰 : ${task.result}")
            }
        }
    }

    fun setCrashlyticsCustomMemNo(memNo: String = "empty") {
        FirebaseCrashlytics.getInstance().setCustomKey(CRASHLYTICS_KEY_MEM_NO, memNo)
    }

    fun setCrashlyticsCustomAppState(state: String) {
        FirebaseCrashlytics.getInstance().setCustomKey(CRASHLYTICS_KEY_APP_STATE, state)
    }

    /** 사운드, 진동 푸시 채널 */
    private val channelSound =
        fun(context: Context) = NotificationChannel(
            NotificationConstants.CHANNEL_ID_SOUND,
            context.getString(R.string.notification_sound),
            NotificationManager.IMPORTANCE_HIGH
        ).apply {
            lightColor = Color.YELLOW
            enableLights(true)
            enableVibration(true)
            setShowBadge(true)
        }

    /** 진동 푸시 채널 */
    private val channelVibrate =
        fun(context: Context) = NotificationChannel(
            NotificationConstants.CHANNEL_ID_VIBRATE,
            context.getString(R.string.notification_vibrate),
            NotificationConstants.CHANNEL_IMPORTANCE_HIGH
        ).apply {
            lightColor = Color.YELLOW
            enableLights(true)
            enableVibration(true)
            setShowBadge(true)
            setSound(null, null)
        }

    /** 뮤트 푸시 채널 */
    private val channelMute =
        fun(context: Context) = NotificationChannel(
            NotificationConstants.CHANNEL_ID_MUTE,
            context.getString(R.string.notification_mute),
            NotificationConstants.CHANNEL_IMPORTANCE_HIGH
        ).apply {
            lightColor = Color.YELLOW
            enableLights(true)
            enableVibration(false)
            setShowBadge(true)
            setSound(null, null)
        }

    /** 채널 리스트 생성 */
    fun makePushChannels(context: Context) {
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelList = listOf(
            channelSound.invoke(context),
            channelVibrate.invoke(context),
            channelMute.invoke(context)
        )

        notificationManager.createNotificationChannels(channelList)
    }
}