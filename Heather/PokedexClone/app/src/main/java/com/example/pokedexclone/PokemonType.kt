package com.example.pokedexclone

enum class PokemonType(val typeName: String, val backgroundColor: Int) {
    GRASS("풀", R.color.grass_type),
    POISON("독", R.color.poison_type),
    FIRE("불꽃", R.color.fire_type),
    FLYING("비행", R.color.flying_type),
    WATER("물", R.color.water_type),
    BUG("벌레", R.color.bug_type),
    NORMAL("노말", R.color.normal_type)
}