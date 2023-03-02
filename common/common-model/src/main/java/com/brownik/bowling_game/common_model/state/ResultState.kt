package com.brownik.bowling_game.common_model.state

import kotlinx.coroutines.flow.MutableStateFlow

fun <T> mutableResultState(
    uiState: ResultState<T> = ResultState.UnInitialize
): MutableStateFlow<ResultState<T>> = MutableStateFlow(uiState)

sealed interface ResultState<out T> {
    object UnInitialize : ResultState<Nothing>
    data class Success<T>(val data: T) : ResultState<T>
    data class Error(val error: Throwable? = null) : ResultState<Nothing>
    object Loading : ResultState<Nothing>
    object Finish : ResultState<Nothing>
}