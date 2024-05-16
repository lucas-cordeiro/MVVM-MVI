package br.com.lucascordeiro.mvvm_mvi.domain.model

import androidx.compose.ui.graphics.Color

sealed class PokemonType(
    val name: String,
    val color: Color
) {
    data object Normal : PokemonType("Normal", Color(0xFFA8A77A))
    data object Fire : PokemonType("Fire", Color(0xFFEE8130))
    data object Water : PokemonType("Water", Color(0xFF6390F0))
    data object Electric : PokemonType("Electric", Color(0xFFF7D02C))
    data object Grass : PokemonType("Grass", Color(0xFF7AC74C))
    data object Ice : PokemonType("Ice", Color(0xFF96D9D6))
    data object Fighting : PokemonType("Fighting", Color(0xFFC22E28))
    data object Poison : PokemonType("Poison", Color(0xFFA33EA1))
    data object Ground : PokemonType("Ground", Color(0xFFE2BF65))
    data object Flying : PokemonType("Flying", Color(0xFFA98FF3))
    data object Psychic : PokemonType("Psychic", Color(0xFFF95587))
    data object Bug : PokemonType("Bug", Color(0xFFA6B91A))
    data object Rock : PokemonType("Rock", Color(0xFFB6A136))
    data object Ghost : PokemonType("Ghost", Color(0xFF735797))
    data object Dragon : PokemonType("Dragon", Color(0xFF6F35FC))
    data object Dark : PokemonType("Dark", Color(0xFF705746))
    data object Steel : PokemonType("Steel", Color(0xFFB7B7CE))
    data object Fairy : PokemonType("Fairy", Color(0xFFD685AD))
}
