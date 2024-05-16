package br.com.lucascordeiro.mvvm_mvi.presentation.screens.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.lucascordeiro.mvvm_mvi.domain.model.Pokemon
import br.com.lucascordeiro.mvvm_mvi.presentation.utils.capitalize
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel()
) {
    val pokemons = viewModel.pokemons
    LazyColumn(modifier = modifier) {
        items(pokemons) { pokemon ->
            PokemonCard(pokemon = pokemon)
        }
    }
}

@Composable
private fun PokemonCard(
    pokemon: Pokemon,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        AsyncImage(
            model = pokemon.pictureUrl,
            contentDescription = pokemon.name,
            modifier = Modifier.size(100.dp)
        )

        Text(
            text = "${pokemon.name.capitalize()}}\n" +
                    "Types: ${pokemon.types.joinToString { type -> type.name }}"
        )
    }
}