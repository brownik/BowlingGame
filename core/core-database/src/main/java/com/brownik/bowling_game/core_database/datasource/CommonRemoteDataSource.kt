package com.brownik.bowling_game.core_database.datasource

import com.brownik.bowling_game.common_model.AutoSignInData
import kotlinx.coroutines.flow.Flow

interface CommonRemoteDataSource {
    fun checkAutoSignIn(): Flow<AutoSignInData>
}