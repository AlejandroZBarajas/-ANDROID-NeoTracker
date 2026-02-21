package com.aleztudio.neotracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aleztudio.neotracker.ui.theme.NEOTrackerTheme
import com.aleztudio.neotracker.features.neo.presentation.screens.NeoScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity(){
    override fun onCreate ( savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            NEOTrackerTheme() {
                NeoScreen()
            }
        }
    }
}
