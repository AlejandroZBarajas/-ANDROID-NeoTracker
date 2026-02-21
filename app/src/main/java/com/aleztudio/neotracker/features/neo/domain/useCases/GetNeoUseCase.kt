package com.aleztudio.neotracker.features.neo.domain.useCases

import com.aleztudio.neotracker.features.neo.domain.entity.Neo
import com.aleztudio.neotracker.features.neo.domain.repositories.NeoRepository
import javax.inject.Inject

class GetNeoUseCase @Inject constructor(
    private val repository: NeoRepository
){
    suspend operator fun invoke(): Result<List<Neo>>{
        return try{
            val neos = repository.getNeo()
            Result.success(neos)
        } catch (e: Exception){
            Result.failure(e)
            }
    }
}