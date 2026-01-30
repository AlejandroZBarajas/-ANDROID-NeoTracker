package com.aleztudio.neotracker.features.neo.data.datasource.remote.model

import com.google.gson.annotations.SerializedName
data class NeoResponse(
    @SerializedName("element_count")
    val elementCount: Int,

    @SerializedName("near_earth_objects")
    val nearEarthObjects: Map<String, List<NeoDto> >,
    val results: List<NeoDto>
)
data class NeoDto(

    @SerializedName("name")
    val name: String,

    @SerializedName("estimated_diameter")
    val estimatedDiameter: EstimatedDiameter,

    @SerializedName("is_potentially_hazardous_asteroid")
    val isPotentiallyHazardousAsteroid: Boolean,

    @SerializedName("close_approach_data")
    val closeApproachData: List<CloseApproachData>
)

data class EstimatedDiameter(
    @SerializedName("kilometers")
    val kilometers: DiameterRange
)

data class DiameterRange(
    @SerializedName("estimated_diameter_min")
    val estimatedDiameterMin: Float,

    @SerializedName("estimated_diameter_max")
    val estimatedDiameterMax: Float
)

data class CloseApproachData(
    @SerializedName("relative_velocity")
    val relativeVelocity: RelativeVelocity
)

data class RelativeVelocity(
    @SerializedName("kilometers_per_second")
    val kilometersPerSecond: String
)