package com.brownik.bowling_game.common_model

data class UserInfoData(
    val memNick: String = "", // 닉네임
    val memNo: Int = 0, // 회원번호
    val gender: String = "", // 'm' 남자, 'f' 여자
)