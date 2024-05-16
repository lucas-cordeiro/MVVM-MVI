package br.com.lucascordeiro.mvvm_mvi.presentation.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucascordeiro.mvvm_mvi.domain.usecase.GetPokemonListUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val getPokemonListUseCase: GetPokemonListUseCase,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            val pokemons = withContext(ioDispatcher) { getPokemonListUseCase() }
            Log.d("HomeViewModel", "Pokemons: $pokemons")
        }
    }
}