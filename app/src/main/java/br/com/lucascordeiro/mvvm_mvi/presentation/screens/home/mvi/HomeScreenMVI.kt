package br.com.lucascordeiro.mvvm_mvi.presentation.screens.home.mvi

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        onIntent = { intent ->
            when (intent) {
                is HomeIntentMVI.PokemonDetail -> {
                    /*navigate to details*/
                }

                else -> Unit
            }

            viewModel.onIntent(intent)
        }
    )
}

// Annotation ExperimentalFoundationApi is needed to use animateItemPlacement
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun Content(
    state: HomeScreenUiStateMVI,
    onIntent: (HomeIntentMVI) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
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
                onIntent = onIntent,
                modifier = Modifier.animateItemPlacement()
            )
        }
    }
}

@Composable
private fun PokemonCard(
    pokemon: Pokemon,
    onIntent: (HomeIntentMVI) -> Unit,
    modifier: Modifier = Modifier
) {
    val color = pokemon.types.first().color
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
            .background(color.copy(alpha = 0.1f))
            .clickable { onIntent(HomeIntentMVI.PokemonDetail(pokemon)) }
            .padding(4.dp)
    ) {
        AsyncImage(
            model = pokemon.pictureUrl,
            contentDescription = pokemon.name,
            modifier = Modifier.size(80.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = pokemon.name.capitalize(),
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.padding(top = 20.dp)
            ) {
                pokemon.types.forEach { type ->
                    Box(
                        modifier = Modifier
                            .clip(MaterialTheme.shapes.small)
                            .background(type.color.copy(alpha = 0.6f))
                            .padding(horizontal = 4.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = type.name.capitalize(),
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }
                }
            }
        }

        IconButton(
            onClick = { onIntent(HomeIntentMVI.PokemonFavorite(pokemon)) }
        ) {
            Icon(
                imageVector = if (pokemon.isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                contentDescription = "Favorite",
                tint = color
            )
        }

        IconButton(
            onClick = { onIntent(HomeIntentMVI.PokemonArchive(pokemon)) }
        ) {
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = "Archive",
                tint = color
            )
        }
    }
}

