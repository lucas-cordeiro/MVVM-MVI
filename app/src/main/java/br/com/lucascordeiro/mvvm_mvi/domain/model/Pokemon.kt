package br.com.lucascordeiro.mvvm_mvi.domain.model

data class Pokemon(
    val id: Long,
    val name: String,
    val pictureUrl: String,
    val types: List<PokemonType>,
    val isFavorite: Boolean,
    val isArchived: Boolean
) {
    fun canArchive() : Boolean {
        return !isFavorite
    }
}
