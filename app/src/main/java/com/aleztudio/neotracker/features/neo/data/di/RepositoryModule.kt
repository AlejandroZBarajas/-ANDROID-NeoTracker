package com.aleztudio.neotracker.features.neo.data.di

import com.aleztudio.neotracker.features.neo.data.repository.NeoRepositoryImplementation
import com.aleztudio.neotracker.features.neo.domain.interfaces.NeoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{
    @Binds
    abstract fun bindNeoRepo(
        neoRepositoryImpl: NeoRepositoryImplementation
    ): NeoRepository
}