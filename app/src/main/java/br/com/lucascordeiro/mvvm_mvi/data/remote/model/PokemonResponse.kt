package br.com.lucascordeiro.mvvm_mvi.data.remote.model

import br.com.lucascordeiro.mvvm_mvi.domain.model.Pokemon
import br.com.lucascordeiro.mvvm_mvi.domain.model.PokemonType
import kotlinx.serialization.Serializable

@Serializable
data class PokemonResponse(
    val id: Long,
    val name: String,
    val pictureUrl: String? = null,
    val types: List<String>
) {
    fun toPokemon() = Pokemon(
        id = id,
        name = name,
        pictureUrl = pictureUrl.orEmpty(),
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