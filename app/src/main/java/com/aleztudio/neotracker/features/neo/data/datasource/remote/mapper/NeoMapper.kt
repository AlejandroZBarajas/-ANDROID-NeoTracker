package com.aleztudio.neotracker.features.neo.data.datasource.remote.mapper

import com.aleztudio.neotracker.features.neo.data.datasource.remote.model.NeoDto
import com.aleztudio.neotracker.features.neo.domain.entity.Neo

fun NeoDto.toDomain(): Neo{
    return Neo(
        name = this.name,

        diameter = this.estimatedDiameter.kilometers.estimatedDiameterMax,

        dangerous = this.isPotentiallyHazardousAsteroid,

        speedKmSec = this.closeApproachData.firstOrNull()
            ?.relativeVelocity
            ?.kilometersPerSecond
            ?.toFloatOrNull() ?: 0f,

        date = this.closeApproachData.firstOrNull()
            ?.date ?:"",

        url = this.nasaJplUrl,

    )
}