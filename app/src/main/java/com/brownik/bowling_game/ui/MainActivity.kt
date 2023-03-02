package com.brownik.bowling_game.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.brownik.bowling_game.common_base.ui.BaseActivity
import com.brownik.bowling_game.common_util.util.AppConfig
import com.brownik.bowling_game.common_util.util.FirebaseManager
import com.brownik.bowling_game.common_util.util.preference.PreferenceUtil
import com.brownik.bowling_game.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    companion object {
        private var TAG = MainActivity::class.java.simpleName
    }

    private val mainViewModel by viewModels<MainViewModel>()

    @Inject
    lateinit var preferenceUtil: PreferenceUtil

    @Inject
    lateinit var firebaseManager: FirebaseManager

    override fun createBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun initActivity(savedInstanceState: Bundle?) {

    }

    private fun collectViewModel() = with(mainViewModel) {

    }

    private fun checkLogin() {
        AppConfig.pushToken = preferenceUtil.pushToken

    }

    private fun addSignInFragment() {
    }
}