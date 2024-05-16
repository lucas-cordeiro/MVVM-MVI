package br.com.lucascordeiro.mvvm_mvi.presentation.screens.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucascordeiro.mvvm_mvi.domain.model.Pokemon
import br.com.lucascordeiro.mvvm_mvi.domain.usecase.GetPokemonListUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val getPokemonListUseCase: GetPokemonListUseCase,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    var pokemons by mutableStateOf(emptyList<Pokemon>())

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            pokemons = withContext(ioDispatcher) { getPokemonListUseCase() }
        }
    }
}