package com.brownik.bowling_game.core_database.di

import com.brownik.bowling_game.core_database.datasource.CommonRemoteDataSource
import com.brownik.bowling_game.core_database.datasource.CommonRemoteDataSourceImpl
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