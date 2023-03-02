package com.brownik.bowling_game.common_util.di

import com.brownik.bowling_game.common_util.util.ApplicationLifecycleCallback
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ActivityLifecycleModule {

    @Singleton
    @Provides
    fun provideActivityLifecycle() : ApplicationLifecycleCallback = ApplicationLifecycleCallback()
}