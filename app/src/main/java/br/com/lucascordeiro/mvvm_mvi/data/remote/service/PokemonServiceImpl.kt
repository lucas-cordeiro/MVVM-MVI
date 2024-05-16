package br.com.lucascordeiro.mvvm_mvi.data.remote.service

import android.content.Context
import br.com.lucascordeiro.mvvm_mvi.R
import br.com.lucascordeiro.mvvm_mvi.data.remote.model.PokemonResponse
import kotlinx.serialization.json.Json

private const val pokeApiImageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"

class PokemonServiceImpl(
    private val context: Context
) : PokemonService {
    // Mocked data
    override suspend fun getPokemonList(): List<PokemonResponse> {
        // [{"id":1,"name":"bulbasaur","types":["grass","poison"]}, ...]
        val data = readLocalJson()

        // Convert json to list of PokemonResponse
        return Json.decodeFromString<List<PokemonResponse>>(data).map {
            it.copy(pictureUrl = "$pokeApiImageUrl${it.id}.png")
        }
    }

    private fun readLocalJson(): String {
        // Read from local json file raw/pokemon.json
        val inputStream = context.resources.openRawResource(R.raw.pokemon)
        val inputString = inputStream.bufferedReader().use { it.readText() }
        return inputString
    }
}