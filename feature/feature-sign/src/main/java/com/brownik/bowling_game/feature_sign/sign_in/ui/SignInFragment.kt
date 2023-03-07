package com.brownik.bowling_game.feature_sign.sign_in.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.brownik.bowling_game.common_base.ui.BaseFragment
import com.brownik.bowling_game.feature_sign.databinding.FragmentSignInBinding

class SignInFragment: BaseFragment<FragmentSignInBinding>() {

    override val enableBackPressed: Boolean = true

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSignInBinding =
        FragmentSignInBinding.inflate(layoutInflater, container, false)
}