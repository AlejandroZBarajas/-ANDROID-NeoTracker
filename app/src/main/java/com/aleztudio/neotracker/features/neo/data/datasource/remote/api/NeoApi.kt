package com.aleztudio.neotracker.features.neo.data.datasource.remote.api

import com.aleztudio.neotracker.features.neo.data.datasource.remote.model.NeoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NeoApi {
    @GET("neo/rest/v1/feed")
    suspend fun getNeo(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("api_key") apiKey: String = "FGPZ4mbZV2rfWKS99Cogk0u0EjzcPNMtojVmfWs1"
    ): NeoResponse
}