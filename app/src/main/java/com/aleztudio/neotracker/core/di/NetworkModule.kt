package com.aleztudio.neotracker.core.di

import com.aleztudio.neotracker.features.neo.data.datasource.remote.api.NeoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NeoTrakerNetworkModule {
    @Provides
    @Singleton

    fun provideNeoApi(@NeoRetrofit retrofit: Retrofit): NeoApi{
        return retrofit.create(com.aleztudio.neotracker.features.neo.data.datasource.remote.api.NeoApi::class.java)
    }
}