package br.com.lucascordeiro.mvvm_mvi.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.lucascordeiro.mvvm_mvi.presentation.screens.home.mvi.HomeScreenMVI
import br.com.lucascordeiro.mvvm_mvi.presentation.screens.home.mvvm.HomeScreenMVVM

@Composable
fun HomeRoot(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        HomeScreenMVVM()
//        HomeScreenMVI()
    }
}