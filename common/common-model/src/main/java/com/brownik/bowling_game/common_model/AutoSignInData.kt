package com.brownik.bowling_game.common_model

data class AutoSignInData(
    override val code: String,
    override val description: String,
    val result: UserAuthData,
) : RestApiCommonData

data class UserAuthData(
    val memNo: String,
    val memId: String,
)