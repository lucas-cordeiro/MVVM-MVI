package br.com.lucascordeiro.mvvm_mvi.di

import br.com.lucascordeiro.mvvm_mvi.data.remote.service.PokemonService
import br.com.lucascordeiro.mvvm_mvi.data.remote.service.PokemonServiceImpl
import br.com.lucascordeiro.mvvm_mvi.data.repository.PokemonRepositoryImpl
import br.com.lucascordeiro.mvvm_mvi.domain.repository.PokemonRepository
import br.com.lucascordeiro.mvvm_mvi.domain.usecase.GetPokemonListUseCase
import br.com.lucascordeiro.mvvm_mvi.presentation.screens.home.mvi.HomeViewModelMVI
import br.com.lucascordeiro.mvvm_mvi.presentation.screens.home.mvvm.HomeViewModelMVVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModules {
    private val remoteModule = module {
        single<PokemonService> { PokemonServiceImpl(context = get()) }
    }

    private val repositoryModule = module {
        factory<PokemonRepository> { PokemonRepositoryImpl(service = get()) }
    }

    private val useCaseModule = module {
        factory { GetPokemonListUseCase(get<PokemonRepository>()::getPokemonList) }
    }

    private val viewModelModule = module {
        viewModel { HomeViewModelMVVM(getPokemonListUseCase = get()) }
        viewModel { HomeViewModelMVI(getPokemonListUseCase = get()) }
    }

    val modules = listOf(
        remoteModule,
        repositoryModule,
        useCaseModule,
        viewModelModule
    )
}