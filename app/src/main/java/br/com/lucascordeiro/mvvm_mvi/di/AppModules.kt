package br.com.lucascordeiro.mvvm_mvi.di

import br.com.lucascordeiro.mvvm_mvi.data.remote.service.PokemonService
import br.com.lucascordeiro.mvvm_mvi.data.remote.service.PokemonServiceImpl
import br.com.lucascordeiro.mvvm_mvi.data.repository.PokemonRepositoryImpl
import br.com.lucascordeiro.mvvm_mvi.domain.repository.PokemonRepository
import br.com.lucascordeiro.mvvm_mvi.domain.usecase.GetPokemonListUseCase
import br.com.lucascordeiro.mvvm_mvi.presentation.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModules {
    private val remoteModule = module {
        single<PokemonService> { PokemonServiceImpl() }
    }

    private val repositoryModule = module {
        factory<PokemonRepository> { PokemonRepositoryImpl(service = get()) }
    }

    private val useCaseModule = module {
        factory { GetPokemonListUseCase(get<PokemonRepository>()::getPokemonList) }
    }

    private val viewModelModule = module {
        viewModel { HomeViewModel(getPokemonListUseCase = get()) }
    }

    val modules = listOf(
        remoteModule,
        repositoryModule,
        useCaseModule,
        viewModelModule
    )
}