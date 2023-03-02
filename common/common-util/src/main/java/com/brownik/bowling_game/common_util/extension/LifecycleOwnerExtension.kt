package com.brownik.bowling_game.common_util.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun LifecycleOwner.delay(delay: Long, action: () -> Unit): Job {
    return lifecycleScope.launch {
        kotlinx.coroutines.delay(delay)
        action.invoke()
    }
}