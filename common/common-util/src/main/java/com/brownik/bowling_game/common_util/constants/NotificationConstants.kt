package com.brownik.bowling_game.common_util.constants

import android.app.NotificationManager

object NotificationConstants {

    const val CHANNEL_ID_SOUND = "CHANNEL_ID_SOUND"
    const val CHANNEL_ID_VIBRATE = "CHANNEL_ID_VIBRATE"
    const val CHANNEL_ID_MUTE = "CHANNEL_ID_MUTE"

    const val CHANNEL_IMPORTANCE_HIGH = NotificationManager.IMPORTANCE_HIGH
    const val NOTIFICATION_RECEIVED_DATA = "NOTIFICATION_RECEIVED_DATA"

    const val GROUP_ID = 10000

    var pushData = mapOf<String, String>()

    const val PUSH_TYPE_ADMIN = 1       // 운영자
    const val PUSH_TYPE_INQUIRY = 7     // 1:1 문의
}