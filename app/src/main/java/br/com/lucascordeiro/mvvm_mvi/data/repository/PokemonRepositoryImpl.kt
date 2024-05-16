package br.com.lucascordeiro.mvvm_mvi.data.repository

import br.com.lucascordeiro.mvvm_mvi.data.remote.service.PokemonService
import br.com.lucascordeiro.mvvm_mvi.domain.model.Pokemon
import br.com.lucascordeiro.mvvm_mvi.domain.repository.PokemonRepository

class PokemonRepositoryImpl(
    private val service: PokemonService
) : PokemonRepository {
    override suspend fun getPokemonList(): List<Pokemon> {
        return service.getPokemonList().map { it.toPokemon() }
    }
}