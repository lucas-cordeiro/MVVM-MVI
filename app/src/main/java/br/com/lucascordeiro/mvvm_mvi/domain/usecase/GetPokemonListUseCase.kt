package br.com.lucascordeiro.mvvm_mvi.domain.usecase

import br.com.lucascordeiro.mvvm_mvi.domain.model.Pokemon

fun interface GetPokemonListUseCase : suspend () -> List<Pokemon>