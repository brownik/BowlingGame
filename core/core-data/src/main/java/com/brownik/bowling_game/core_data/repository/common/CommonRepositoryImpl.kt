package com.brownik.bowling_game.core_data.repository.common

import com.brownik.bowling_game.common_model.AutoSignInData
import com.brownik.bowling_game.core_database.datasource.CommonRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CommonRepositoryImpl @Inject constructor(
    private val dataSource: CommonRemoteDataSource,
) : CommonRepository {
    override fun checkAutoSignIn(): Flow<AutoSignInData> = dataSource.checkAutoSignIn()
}