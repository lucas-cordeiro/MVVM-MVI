package br.com.lucascordeiro.mvvm_mvi.data.remote.service

import br.com.lucascordeiro.mvvm_mvi.data.remote.model.PokemonResponse

interface PokemonService {
    suspend fun getPokemonList(): List<PokemonResponse>
}