package com.brownik.bowling_game.common_util.di

import android.content.Context
import com.brownik.bowling_game.common_util.util.FirebaseManager
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FirebaseModule {

    @Singleton
    @Provides
    fun provideFirebaseManager(firebaseAnalytics: FirebaseAnalytics): FirebaseManager =
        FirebaseManager(firebaseAnalytics)

    @Singleton
    @Provides
    fun provideFirebaseAnalytics(@ApplicationContext context: Context): FirebaseAnalytics =
        FirebaseAnalytics.getInstance(context)
}