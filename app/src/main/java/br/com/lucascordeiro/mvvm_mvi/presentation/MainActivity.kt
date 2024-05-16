package br.com.lucascordeiro.mvvm_mvi.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import br.com.lucascordeiro.mvvm_mvi.presentation.screens.home.HomeRoot
import br.com.lucascordeiro.mvvm_mvi.presentation.screens.home.mvvm.HomeScreenMVVM
import br.com.lucascordeiro.mvvm_mvi.presentation.theme.MVVM_MVITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVM_MVITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeRoot(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}