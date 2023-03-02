package com.brownik.bowling_game.common_util.util

import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class ResultObserver(private val registry: ActivityResultRegistry) : DefaultLifecycleObserver {

    companion object {
        const val intentKey = "intentKey"
    }

    lateinit var getIntentContent: ActivityResultLauncher<Intent>

    var intentCallback: ((ActivityResult) -> Unit)? = null

    private var waitIntent: Intent? = null

    override fun onCreate(owner: LifecycleOwner) {
        getIntentContent = registry.register(
            intentKey,
            owner,
            ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback { _result ->
                intentCallback?.invoke(_result)
            }
        )

        waitIntent?.let {
            getIntentContent.launch(it)
            waitIntent = null
        }
    }

    fun startActivity(intent: Intent, callback: (ActivityResult) -> Unit) {
        intentCallback = callback
        if (::getIntentContent.isInitialized) getIntentContent.launch(intent)
        else waitIntent = intent
    }
}