package com.aleztudio.neotracker.features.neo.domain.interfaces

import com.aleztudio.neotracker.features.neo.domain.entity.Neo

interface NeoRepository{
    suspend fun getNeo(startDate: String? = null, endDate: String? = null):List<Neo>
}