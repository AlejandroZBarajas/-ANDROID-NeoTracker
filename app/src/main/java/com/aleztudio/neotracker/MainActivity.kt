package com.aleztudio.neotracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aleztudio.neotracker.ui.theme.NEOTrackerTheme
import com.aleztudio.neotracker.features.neo.presentation.screens.NeoScreen
import com.aleztudio.neotracker.features.neo.presentation.viewModels.NeoViewModelFactory
import com.aleztudio.neotracker.core.di.AppContainer
import android.content.Intent
import android.net.Uri
class MainActivity : ComponentActivity() {

    private lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        appContainer = AppContainer(applicationContext
        )
        setContent {
            NEOTrackerTheme {
                NeoScreen(
                    factory = NeoViewModelFactory(appContainer.getNeoUseCase),
                    onNavigateToUrl =  { url ->
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        startActivity(intent)
                    }
                )
            }
        }
    }
}



