package br.com.lucascordeiro.mvvm_mvi.presentation.screens.home.mvi

import br.com.lucascordeiro.mvvm_mvi.domain.model.Pokemon

sealed class HomeIntentMVI {
    data class PokemonDetail(val pokemon: Pokemon) : HomeIntentMVI()
    data class PokemonFavorite(val pokemon: Pokemon) : HomeIntentMVI()
    data class PokemonArchive(val pokemon: Pokemon) : HomeIntentMVI()
}