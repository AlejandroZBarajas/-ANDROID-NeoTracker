package com.aleztudio.neotracker.features.neo.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.aleztudio.neotracker.features.neo.domain.useCases.GetNeoUseCase

class NeoViewModelFactory(
    private val getNeoUseCase: GetNeoUseCase
): ViewModelProvider.Factory{

    override fun <T : ViewModel> create (modelClass: Class<T>): T{
        if (modelClass.isAssignableFrom(NeoViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return NeoViewModel(getNeoUseCase) as T
        }
        throw IllegalArgumentException("Unknown viewmodel class: ${modelClass.name}")
    }
}