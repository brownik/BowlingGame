package com.brownik.bowling_game.core_database.datasource

import com.brownik.bowling_game.common_model.AutoSignInData
import com.brownik.bowling_game.core_database.service.CommonService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CommonRemoteDataSourceImpl @Inject constructor(
    private val service: CommonService
) : CommonRemoteDataSource{
    override fun checkAutoSignIn(): Flow<AutoSignInData> = service.checkAutoSignIn()
}