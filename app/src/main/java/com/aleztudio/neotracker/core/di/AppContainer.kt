package com.aleztudio.neotracker.core.di

import com.aleztudio.neotracker.BuildConfig
import android.content.Context
import com.aleztudio.neotracker.core.network.NeoApi
import com.aleztudio.neotracker.features.neo.data.repository.NeoRepositoryImplementation
import com.aleztudio.neotracker.features.neo.domain.interfaces.NeoRepository
import com.aleztudio.neotracker.features.neo.domain.useCases.GetNeoUseCase

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer (context: Context){
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val neoApi:NeoApi by lazy{
        retrofit.create(NeoApi::class.java)
    }

    val neoRepository: NeoRepository by lazy{
        NeoRepositoryImplementation(neoApi)
    }

    val getNeoUseCase: GetNeoUseCase by lazy {
        GetNeoUseCase(neoRepository)
    }
}