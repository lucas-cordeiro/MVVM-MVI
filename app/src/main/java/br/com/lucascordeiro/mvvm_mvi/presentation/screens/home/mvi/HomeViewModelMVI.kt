package br.com.lucascordeiro.mvvm_mvi.presentation.screens.home.mvi

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

class HomeViewModelMVI(
    private val getPokemonListUseCase: GetPokemonListUseCase,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    var state by mutableStateOf(HomeScreenUiStateMVI())
        private set

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)

            val pokemons = withContext(ioDispatcher) {
                //some delay to see the loading
                delay(2000)

                getPokemonListUseCase()
            }

            state = state.copy(
                isLoading = false,
                pokemons = pokemons
            )
        }
    }

    fun onAction(action: HomeActionMVI) {
        when(action){
            is HomeActionMVI.PokemonFavorite -> {
                favoritePokemon(action.pokemon)
            }
            is HomeActionMVI.PokemonArchive -> {
                archivePokemon(action.pokemon)
            }
            else -> Unit
        }
    }

    private fun favoritePokemon(pokemon: Pokemon) {
        viewModelScope.launch {
            val pokemons = state.pokemons.map {
                if (it.id == pokemon.id) {
                    it.copy(isFavorite = !it.isFavorite)
                } else {
                    it
                }
            }
            state = state.copy(pokemons = pokemons)
        }
    }

    private fun archivePokemon(pokemon: Pokemon) {
        viewModelScope.launch {
           val pokemons = state.pokemons.filter { it.id != pokemon.id }
              state = state.copy(pokemons = pokemons)
        }
    }
}