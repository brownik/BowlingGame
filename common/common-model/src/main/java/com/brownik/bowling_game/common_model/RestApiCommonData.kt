package com.brownik.bowling_game.common_model

interface RestApiCommonData {
    val code: String
    val description: String

    companion object {
        const val RESULT_SUCCESS = "1"
        const val RESULT_ERROR = "0"
    }

    val isSuccess: Boolean get() = code == RESULT_SUCCESS
}