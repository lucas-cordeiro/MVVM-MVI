package br.com.lucascordeiro.mvvm_mvi.presentation.screens.home.mvi

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.lucascordeiro.mvvm_mvi.domain.model.Pokemon
import br.com.lucascordeiro.mvvm_mvi.presentation.utils.capitalize
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreenMVI(
    viewModel: HomeViewModelMVI = koinViewModel()
) {
    val state = viewModel.state

    Content(
        state = state,
        onAction = { action ->
            when(action) {
                is HomeActionMVI.PokemonDetail -> { /*navigate to details*/ }
                else -> Unit
            }

            viewModel.onAction(action)
        }
    )
}

// Annotation ExperimentalFoundationApi is needed to use animateItemPlacement
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun Content(
    state: HomeScreenUiStateMVI,
    onAction: (HomeActionMVI) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        item {
            if (state.isLoading) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                ) {
                    CircularProgressIndicator()
                }
            }
        }

        items(
            items = state.pokemons,
            key = { pokemon -> pokemon.id }
        ) { pokemon ->
            PokemonCard(
                pokemon = pokemon,
                onAction = onAction,
                modifier = Modifier.animateItemPlacement()
            )
        }
    }
}

@Composable
private fun PokemonCard(
    pokemon: Pokemon,
    onAction: (HomeActionMVI) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clickable { onAction(HomeActionMVI.PokemonDetail(pokemon)) }
    ) {
        AsyncImage(
            model = pokemon.pictureUrl,
            contentDescription = pokemon.name,
            modifier = Modifier.size(100.dp)
        )

        Text(
            text = "${pokemon.name.capitalize()}\n" +
                    "Types: ${pokemon.types.joinToString { type -> type.name }}"
        )

        IconButton(
            onClick = { onAction(HomeActionMVI.PokemonFavorite(pokemon)) }
        ) {
            Icon(
                imageVector = if (pokemon.isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                contentDescription = "Favorite",
                tint = MaterialTheme.colorScheme.primary
            )
        }

        IconButton(
            onClick = { onAction(HomeActionMVI.PokemonArchive(pokemon)) }
        ) {
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = "Archive",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

