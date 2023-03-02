package com.brownik.bowling_game.core_network.di

import com.brownik.bowling_game.core_network.datasource.common.CommonRemoteDataSource
import com.brownik.bowling_game.core_network.datasource.common.CommonRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindCommonDataSource(dataSource: CommonRemoteDataSourceImpl): CommonRemoteDataSource
}