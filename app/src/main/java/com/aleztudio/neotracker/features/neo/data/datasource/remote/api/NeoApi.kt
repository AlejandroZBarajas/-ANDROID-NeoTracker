package com.aleztudio.neotracker.features.neo.data.datasource.remote.api

import com.aleztudio.neotracker.features.neo.data.datasource.remote.model.NeoDto
import com.aleztudio.neotracker.features.neo.data.datasource.remote.model.NeoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NeoApi {
    @GET("neo/rest/v1/feed")
    suspend fun getNeos( // <--- Nota que es plural
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("api_key") apiKey: String = "TU_KEY"
    ): NeoResponse
}