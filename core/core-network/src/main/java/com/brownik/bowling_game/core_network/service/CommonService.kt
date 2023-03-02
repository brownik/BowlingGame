package com.brownik.bowling_game.core_network.service

import com.brownik.bowling_game.common_model.AutoSignInData
import kotlinx.coroutines.flow.Flow

interface CommonService {
    fun checkAutoSignIn(): Flow<AutoSignInData>
}