package com.brownik.bowling_game.common_util.util

import android.content.Context
import com.brownik.bowling_game.common_model.ServerInfoData
import com.brownik.bowling_game.common_model.UserInfoData
import com.brownik.bowling_game.common_util.extension.*

object AppConfig {

    fun init(context: Context) {
        deviceId = context.getDeviceId()
        appVersion = context.getAppVersion()
        androidVersion = context.getAndroidVersion()
        storeType = "209"
    }

    /** 앱 기본 정보 */
    var deviceId = ""
    var appVersion = ""
    var androidVersion = ""
    var storeType = ""
    const val deviceType = "a"
    var myInfo = UserInfoData()

    /** url 관련 */
    var myIp = ""
    var currentServerInfo = ServerInfoData()

    /** WebView 관련 */
    const val AGENT_PREFIX = "BOWLING-GAME"
    var webViewAgentCode = ""
    var webViewAgent = ""
    var cookie: String = ""

    /** Window 관련 */
    var statusBarHeight = 0
    var systemBarHeight = 0

    /** Push 관련 */
    var isAppOnForeground = false
    var pushToken: String = ""
        set(token) {
            field = token
            updateWebViewAgentCode()
        }

    private fun updateWebViewAgentCode() {
        webViewAgentCode = "$AGENT_PREFIX|$deviceType|$deviceId|$pushToken|$appVersion|$androidVersion|$storeType"
    }
}