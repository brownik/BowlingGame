package com.brownik.bowling_game.ui

import android.app.Application
import com.brownik.bowling_game.common_base.ui.BaseViewModel
import com.brownik.bowling_game.common_model.AutoSignInData
import com.brownik.bowling_game.common_model.state.mutableResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    app: Application
) : BaseViewModel(app) {

    private val _checkAutoSignInState = mutableResultState<AutoSignInData>()
    val checkAutoSignInState = _checkAutoSignInState.asStateFlow()

    fun autoSignIn() {

    }
}