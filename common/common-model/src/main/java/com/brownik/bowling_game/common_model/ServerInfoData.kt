package com.brownik.bowling_game.common_model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ServerInfoData(
    val serverName: String = "",
    val webUrl: String = "",
    val apiUrl: String = "",
) : Parcelable