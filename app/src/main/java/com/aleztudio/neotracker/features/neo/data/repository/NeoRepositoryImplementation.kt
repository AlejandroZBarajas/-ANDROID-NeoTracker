package com.aleztudio.neotracker.features.neo.data.repository

import com.aleztudio.neotracker.core.network.NeoApi
import com.aleztudio.neotracker.features.neo.domain.interfaces.NeoRepository
import com.aleztudio.neotracker.features.neo.domain.entity.Neo
import com.aleztudio.neotracker.features.neo.data.datasource.remote.mapper.toDomain
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import android.util.Log
import com.aleztudio.neotracker.BuildConfig

class NeoRepositoryImplementation(
    private val api: NeoApi
): NeoRepository{
    override suspend fun getNeo(startDate: String?, endDate: String?): List<Neo> {

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val startDate = LocalDate.now().format(formatter)
        val endDate = LocalDate.now().plusDays(7).format(formatter)

        Log.e("NeoRepository", "===== INICIANDO PETICIÓN =====")
        Log.e("NeoRepository", "StartDate: $startDate")
        Log.e("NeoRepository", "EndDate: $endDate")
        Log.e("NeoRepository", "Base URL: ${BuildConfig.BASE_URL}")
        Log.e("NeoRepository", "URL completa: ${BuildConfig.BASE_URL}neo/rest/v1/feed?start_date=$startDate&end_date=$endDate&api_key=FGPZ4mbZV2rfWKS99Cogk0u0EjzcPNMtojVmfWs1")

        try{
            val response = api.getNeos(
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