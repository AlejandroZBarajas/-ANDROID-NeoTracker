package com.aleztudio.neotracker.features.neo.presentation.screens

import com.aleztudio.neotracker.features.neo.domain.entity.Neo

data class NeoUiState(
    val isLoading: Boolean = false,

    val neos: List<Neo> = emptyList(),

    val error: String? = null,

    val isRefreshing: Boolean = false
)