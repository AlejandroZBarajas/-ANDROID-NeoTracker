package com.aleztudio.neotracker.features.neo.presentation.viewModels

import androidx.lifecycle.ViewModel
import com.aleztudio.neotracker.features.neo.domain.entity.Neo
import com.aleztudio.neotracker.features.neo.domain.useCases.GetNeoUseCase
import com.aleztudio.neotracker.features.neo.presentation.screens.NeoUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NeoViewModel @Inject constructor(
    private val getNeoUseCase: GetNeoUseCase
): ViewModel(){
    private val _uiState = MutableStateFlow(NeoUiState())

    val uiState = _uiState.asStateFlow()

    init{
        loadNeos()
    }

    private fun loadNeos(){
        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            val result = getNeoUseCase()

            _uiState.update { currentState ->
                result.fold(
                    onSuccess = {list ->
                        currentState.copy(isLoading = false, neos = list)
                    },
                    onFailure = { error ->
                        currentState.copy(isLoading = false, error = error.message)
                    }
                )
            }
        }
    }
}