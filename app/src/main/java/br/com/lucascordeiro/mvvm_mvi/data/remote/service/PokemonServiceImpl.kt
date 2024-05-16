package br.com.lucascordeiro.mvvm_mvi.data.remote.service

import br.com.lucascordeiro.mvvm_mvi.data.remote.model.PokemonResponse

private const val pokeApiImageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"

private const val Grass = "grass"
private const val Poison = "poison"
private const val Fire = "fire"
private const val Water = "water"
private const val Bug = "bug"
private const val Normal = "normal"
private const val Electric = "electric"
private const val Ground = "ground"
private const val Fairy = "fairy"
private const val Fighting = "fighting"
private const val Psychic = "psychic"
private const val Rock = "rock"
private const val Ghost = "ghost"
private const val Ice = "ice"
private const val Dragon = "dragon"
private const val Steel = "steel"
private const val Flying = "flying"
private const val Dark = "dark"

class PokemonServiceImpl : PokemonService {
    override suspend fun getPokemonList(): List<PokemonResponse> {
        return listOf(
            PokemonResponse(
                id = 1,
                name = "Bulbasaur",
                pictureUrl = "${pokeApiImageUrl}1.png",
                types = listOf(Grass, Poison)
            ),
            PokemonResponse(
                id = 2,
                name = "Ivysaur",
                pictureUrl = "${pokeApiImageUrl}2.png",
                types = listOf(Grass, Poison)
            ),
            PokemonResponse(
                id = 3,
                name = "Venusaur",
                pictureUrl = "${pokeApiImageUrl}3.png",
                types = listOf(Grass, Poison)
            ),
            PokemonResponse(
                id = 4,
                name = "Charmander",
                pictureUrl = "${pokeApiImageUrl}4.png",
                types = listOf(Fire)
            ),
            PokemonResponse(
                id = 5,
                name = "Charmeleon",
                pictureUrl = "${pokeApiImageUrl}5.png",
                types = listOf(Fire)
            ),
            PokemonResponse(
                id = 6,
                name = "Charizard",
                pictureUrl = "${pokeApiImageUrl}6.png",
                types = listOf(Fire, Flying)
            ),
            PokemonResponse(
                id = 7,
                name = "Squirtle",
                pictureUrl = "${pokeApiImageUrl}7.png",
                types = listOf(Water)
            ),
            PokemonResponse(
                id = 8,
                name = "Wartortle",
                pictureUrl = "${pokeApiImageUrl}8.png",
                types = listOf(Water)
            ),
            PokemonResponse(
                id = 9,
                name = "Blastoise",
                pictureUrl = "${pokeApiImageUrl}9.png",
                types = listOf(Water)
            ),
        )
    }
}