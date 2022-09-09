package com.jxareas.jetpack.core.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Suppress("DEPRECATION")
    fun sharedPref(@ApplicationContext app: Context): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(app)

}