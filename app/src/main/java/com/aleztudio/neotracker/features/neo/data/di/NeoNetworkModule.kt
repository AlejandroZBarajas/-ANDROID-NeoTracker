package com.aleztudio.neotracker.features.neo.data.di

import com.aleztudio.neotracker.BuildConfig
import com.aleztudio.neotracker.core.di.NeoRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NeoNetworkModule {
    @Provides
    @Singleton
    @NeoRetrofit
    fun provideNeoRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}