package br.com.lucascordeiro.mvvm_mvi.presentation.screens.home.mvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucascordeiro.mvvm_mvi.domain.model.Pokemon
import br.com.lucascordeiro.mvvm_mvi.domain.usecase.GetPokemonListUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModelMVVM(
    private val getPokemonListUseCase: GetPokemonListUseCase,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    var pokemons by mutableStateOf(emptyList<Pokemon>())
    var isLoading by mutableStateOf(false)

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            isLoading = true
            pokemons = withContext(ioDispatcher) {
                //some delay to see the loading
                delay(2000)

                getPokemonListUseCase()
            }
            isLoading = false
        }
    }

    fun clickedFavoritePokemon(pokemon: Pokemon) {
        viewModelScope.launch {
            pokemons = pokemons.map {
                if (it.id == pokemon.id) {
                    it.copy(isFavorite = !it.isFavorite)
                } else {
                    it
                }
            }
        }
    }

    fun clickedArchivePokemon(pokemon: Pokemon) {
        viewModelScope.launch {
            pokemons = pokemons.filter { it.id != pokemon.id }
        }
    }
}