package com.brownik.bowling_game.common_util.util

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.brownik.bowling_game.common_model.state.ResultState
import com.brownik.bowling_game.common_util.extension.clicks
import com.brownik.bowling_game.common_util.extension.collect
import com.brownik.bowling_game.common_util.extension.onUiState
import com.brownik.bowling_game.common_util.extension.throttleFirst
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*

interface LifecycleOwnerWrapper {

    fun initLifecycleOwner() : LifecycleOwner

    fun <T: Any, L: LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T) -> Unit) =
        liveData.observe(this, Observer(body))

    fun <T> Flow<ResultState<T>>.launchInUiState(
        loading: suspend () -> Unit = {},
        success: suspend (T) -> Unit = {},
        error: suspend (Throwable?) -> Unit = {},
        finish: suspend () -> Unit = {}
    ): Job = onUiState(loading, success, error, finish).launchIn(initLifecycleOwner().lifecycleScope)

    fun <T> Flow<T>.onResult(action: (T) -> Unit) {
        collect(initLifecycleOwner().lifecycleScope, action)
    }

    fun <T> LiveData<T>.observe(observer: Observer<T>) {
        observe(initLifecycleOwner(), observer)
    }

    fun View.setFirstClickEvent(
        windowDuration: Long = 1000,
        onClick: () -> Unit,
    ) {
        clicks()
            .throttleFirst(windowDuration)
            .onEach { onClick.invoke() }
            .launchIn(initLifecycleOwner().lifecycleScope)
    }
}