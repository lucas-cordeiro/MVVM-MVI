package br.com.lucascordeiro.mvvm_mvi.data.remote.model

import br.com.lucascordeiro.mvvm_mvi.domain.model.Pokemon
import br.com.lucascordeiro.mvvm_mvi.domain.model.PokemonType

data class PokemonResponse(
    val id: Long,
    val name: String,
    val pictureUrl: String,
    val types: List<String>
) {
    fun toPokemon() = Pokemon(
        id = id,
        name = name,
        pictureUrl = pictureUrl,
        types = types.map { type -> mapType(type) }
    )

    private fun mapType(type: String) : PokemonType {
        return when(type.lowercase()){
            "fighting" -> PokemonType.Fighting
            "flying" -> PokemonType.Flying
            "poison" -> PokemonType.Poison
            "ground" -> PokemonType.Ground
            "rock" -> PokemonType.Rock
            "bug" -> PokemonType.Bug
            "ghost" -> PokemonType.Ghost
            "steel" -> PokemonType.Steel
            "fire" -> PokemonType.Fire
            "water" -> PokemonType.Water
            "grass" -> PokemonType.Grass
            "electric" -> PokemonType.Electric
            "psychic" -> PokemonType.Psychic
            "ice" -> PokemonType.Ice
            "dragon" -> PokemonType.Dragon
            "dark" -> PokemonType.Dark
            "fairy" -> PokemonType.Fairy
            else -> PokemonType.Normal
        }
    }
}