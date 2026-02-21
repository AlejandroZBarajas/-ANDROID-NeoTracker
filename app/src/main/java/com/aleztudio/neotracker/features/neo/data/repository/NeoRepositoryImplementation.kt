package com.aleztudio.neotracker.features.neo.data.repository

import com.aleztudio.neotracker.features.neo.data.datasource.remote.api.NeoApi
import com.aleztudio.neotracker.features.neo.domain.interfaces.NeoRepository
import com.aleztudio.neotracker.features.neo.domain.entity.Neo
import com.aleztudio.neotracker.features.neo.data.datasource.remote.mapper.toDomain
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import android.util.Log
import com.aleztudio.neotracker.BuildConfig
import javax.inject.Inject

class NeoRepositoryImplementation @Inject constructor(
    private val api: NeoApi
): NeoRepository{
    override suspend fun getNeo(startDate: String?, endDate: String?): List<Neo> {

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val startDate = LocalDate.now().format(formatter)
        val endDate = LocalDate.now().plusDays(7).format(formatter)

        try{
            val response = api.getNeos (
                startDate= startDate,
                endDate= endDate
            )
            val allNeos = response.nearEarthObjects.values.flatten()

            Log.e("NeoRepository", "Total NEOs encontrados: ${allNeos.size}")

            return allNeos.map { it.toDomain()}

        }catch (e: Exception){
            Log.e("NeoRepository", "ERROR: ${e.message}")
            Log.e("NeoRepository", "Stack trace: ", e)
            throw e
        }
    }
}