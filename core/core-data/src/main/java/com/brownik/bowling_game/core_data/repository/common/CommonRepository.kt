package com.brownik.bowling_game.core_data.repository.common

import com.brownik.bowling_game.common_model.AutoSignInData
import kotlinx.coroutines.flow.Flow

interface CommonRepository {
    fun checkAutoSignIn(): Flow<AutoSignInData>
}