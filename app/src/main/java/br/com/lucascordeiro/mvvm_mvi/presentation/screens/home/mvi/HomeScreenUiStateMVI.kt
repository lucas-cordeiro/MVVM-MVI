package br.com.lucascordeiro.mvvm_mvi.presentation.screens.home.mvi

import br.com.lucascordeiro.mvvm_mvi.domain.model.Pokemon

data class HomeScreenUiStateMVI(
    val pokemons: List<Pokemon> = emptyList(),
    val isLoading: Boolean = false
)
