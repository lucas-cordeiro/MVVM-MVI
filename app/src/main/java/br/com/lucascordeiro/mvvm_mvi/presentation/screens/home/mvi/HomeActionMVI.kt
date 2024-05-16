package br.com.lucascordeiro.mvvm_mvi.presentation.screens.home.mvi

import br.com.lucascordeiro.mvvm_mvi.domain.model.Pokemon

sealed class HomeActionMVI {
    data class PokemonDetail(val pokemon: Pokemon) : HomeActionMVI()
    data class PokemonFavorite(val pokemon: Pokemon) : HomeActionMVI()
    data class PokemonArchive(val pokemon: Pokemon) : HomeActionMVI()
}