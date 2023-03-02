package com.brownik.bowling_game.common_base.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import com.brownik.bowling_game.common_base.R
import com.brownik.bowling_game.common_ui.showToastSnackBar
import com.brownik.bowling_game.common_util.util.LifecycleOwnerWrapper
import com.brownik.bowling_game.common_util.extension.delay
import com.brownik.bowling_game.common_util.extension.showToast
import com.brownik.bowling_game.common_util.util.BaseLog
import com.brownik.bowling_game.common_util.util.ResultObserver
import kotlin.system.exitProcess

abstract class BaseActivity<Binding : ViewDataBinding> : AppCompatActivity(),
    LifecycleOwnerWrapper {

    companion object {
        private var TAG = BaseActivity::class.java.simpleName
    }

    protected val binding: Binding by lazy { createBinding() }

    protected abstract fun createBinding(): Binding

    protected open fun initActivity(savedInstanceState: Bundle?) = Unit

    override fun initLifecycleOwner(): LifecycleOwner = this

    private val resultObserver: ResultObserver by lazy {
        ResultObserver(activityResultRegistry)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun showErrorMessage(log: String = "") {
        BaseLog.e("BaseFragment", log)
        showToastSnackBar(R.string.common_error_message)
    }

    fun activityStartForResult(intent: Intent, callback: ((ActivityResult) -> Unit)? = null) {
        resultObserver.startActivity(intent) { result ->
            callback?.invoke(result)
        }
    }

    open fun finishActivity() {
        if (!isFinishing) {
            finish()
        }
    }

    private var isFinish = false

    fun finishAppTwoCall() {
        if (isFinish) finishApplication()
        isFinish = true
        showToast(R.string.finish_back_press_app)
        delay(2000) { isFinish = false }
    }

    fun finishApplication() {
        if (!isFinishing) {
            finishAffinity()
            exitProcess(0)
        }
    }
}