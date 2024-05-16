package br.com.lucascordeiro.mvvm_mvi.domain.repository

import br.com.lucascordeiro.mvvm_mvi.domain.model.Pokemon

interface PokemonRepository {
    suspend fun getPokemonList(): List<Pokemon>
}