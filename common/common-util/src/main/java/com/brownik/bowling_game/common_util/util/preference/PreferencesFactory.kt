package com.brownik.bowling_game.common_util.util.preference

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import java.security.KeyStore

object PreferencesFactory {

    fun getPreferences(context: Context): SharedPreferences =
        try {
            createPreferences(context)
        } catch (e: Exception) {
            deleteMasterKey()
            deletePreferences(context)
            createPreferences(context)
        }

    private fun createPreferences(context: Context): SharedPreferences =
        EncryptedSharedPreferences.create(
            "android",
            "bowling-game",
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

    private fun deleteMasterKey() {
        KeyStore.getInstance("AndroidKeyStore").apply {
            load(null)
            deleteEntry("") // todo ?? 이게 뭘까?
        }
    }

    private fun deletePreferences(context: Context) {
        context.deleteSharedPreferences("android")
    }

}