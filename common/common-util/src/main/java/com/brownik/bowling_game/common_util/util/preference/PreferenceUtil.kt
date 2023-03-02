package com.brownik.bowling_game.common_util.util.preference

import android.content.SharedPreferences
import com.brownik.bowling_game.common_model.UserAuthData
import com.brownik.bowling_game.common_util.util.AppConfig
import javax.inject.Inject

class PreferenceUtil @Inject constructor(
    sharedPreferences: SharedPreferences
) : BasePreference(sharedPreferences) {

    companion object {
        private const val PROPERTY_SESSION_KEY = "PROPERTY_SESSION_KEY"
        private const val PROPERTY_MEM_ID = "PROPERTY_MEM_ID"
        private const val PROPERTY_MEM_NO = "PROPERTY_MEM_NO"
        private const val PROPERTY_COOKIE = "PROPERTY_COOKIE"
        private const val PROPERTY_IS_LOGIN = "PROPERTY_IS_LOGIN"

        const val PROPERTY_PUSHKEY_TOKEN = "PROPERTY_PUSHKEY_TOKEN"
    }

    val memId: String
        get() = get(PROPERTY_MEM_ID)

    val memNo: String
        get() = get(PROPERTY_MEM_NO)

    val cookie: String
        get() = get(PROPERTY_COOKIE)

    val isLogin: Boolean
        get() = get(PROPERTY_IS_LOGIN, false)

    val pushToken: String
        get() = get(PROPERTY_PUSHKEY_TOKEN)

    fun putSessionKey(sessionKey: String) {
        put(PROPERTY_SESSION_KEY, sessionKey)
    }

    fun putMemId(id: String) {
        put(PROPERTY_MEM_ID, id)
    }

    fun putMemNo(memNo: String) {
        put(PROPERTY_MEM_NO, memNo)
    }

    fun putCookie(cookie: String) {
        put(PROPERTY_COOKIE, cookie)
    }

    fun putIsLogin(isLogin: Boolean) {
        put(PROPERTY_IS_LOGIN, isLogin)
    }

    fun putPushToken(token: String) {
        put(PROPERTY_PUSHKEY_TOKEN, token)
    }

    fun setLoginData(userAuthData: UserAuthData, cookie: String? = null) {
        putMemNo(userAuthData.memNo)
        putMemId(userAuthData.memId)
        cookie?.let {
            putCookie(it)
            AppConfig.cookie = it
        }
        putIsLogin(true)
    }

    fun clearLoginData() {
        putIsLogin(false)
        putMemNo("")
        putMemId("")
        putSessionKey("")
        putCookie("")
        AppConfig.cookie = ""
    }
}