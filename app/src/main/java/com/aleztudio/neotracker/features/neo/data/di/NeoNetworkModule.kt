package com.aleztudio.neotracker.features.neo.data.di

import com.aleztudio.neotracker.core.di.NeoRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.aleztudio.neotracker.features.neo.data.datasource.remote.api.NeoApi

@Module
@InstallIn(SingletonComponent::class)

object NeoNetworkModule {
    @Provides
    @Singleton

    fun provideNeoApi(@NeoRetrofit retrofit: Retrofit): NeoApi {
        return retrofit.create(NeoApi::class.java)

    }
}