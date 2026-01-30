package com.aleztudio.neotracker.core.network

import com.aleztudio.neotracker.features.neo.data.datasource.remote.model.NeoResponse
import kotlinx.serialization.Serializable
import retrofit2.http.GET
import retrofit2.http.Query

//https://api.nasa.gov/neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&api_key=DEMO_KEY

interface NeoApi {
    @GET("neo/rest/v1/feed")
    suspend fun getNeos(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate:String,
        @Query("api_key") apiKey: String = "FGPZ4mbZV2rfWKS99Cogk0u0EjzcPNMtojVmfWs1"
    ): NeoResponse
}