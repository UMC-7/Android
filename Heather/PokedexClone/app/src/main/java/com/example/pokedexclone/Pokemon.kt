package com.example.pokedexclone

data class Pokemon(
    val id: String,
    val name: String,
    val image: Int,
    val backgroundColor: Int,
    val primaryType: PokemonType,
    val secondaryType: PokemonType?,
    var isCaught: Boolean = false
)
