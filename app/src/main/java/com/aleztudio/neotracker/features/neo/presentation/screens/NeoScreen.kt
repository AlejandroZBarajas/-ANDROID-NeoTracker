package com.aleztudio.neotracker.features.neo.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aleztudio.neotracker.features.neo.domain.entity.Neo
import com.aleztudio.neotracker.features.neo.presentation.viewModels.NeoViewModel
import com.aleztudio.neotracker.features.neo.presentation.components.NeoCard
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NeoScreen(
    viewModel : NeoViewModel = hiltViewModel()
){
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold (
        modifier = Modifier.fillMaxSize(),

        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Proximos objetos cercanos a la tierra",
                    fontWeight = FontWeight.SemiBold) }
            )
        }
    ){ innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            when{
                uiState.isLoading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                uiState.error != null -> {
                    Text(
                        text = uiState.error?:"Error",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    )
                }
                else ->{
                    LazyColumn (
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(8.dp)
                    ){
                        items(uiState.neos){ neo ->
                            NeoCard(
                                name = neo.name,

                                diameter = neo.diameter,

                                dangerous = neo.dangerous,

                                speedKmSec = neo.speedKmSec,

                                date = neo.date,

                                url= neo.url,

                                onUrlClick = onNavigateToUrl

                            )
                        }
                    }
                }
            }
        }
    }
}