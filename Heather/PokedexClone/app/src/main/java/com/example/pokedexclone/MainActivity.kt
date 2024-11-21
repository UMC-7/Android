package com.example.pokedexclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokedexclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var pokemonDatas = ArrayList<Pokemon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 더미데이터 추가
        initPokemonList()

        val pokemonRVAdapter = PokemonRVAdapter(pokemonDatas)
        binding.mainPokemonRv.adapter = pokemonRVAdapter
        binding.mainPokemonRv.layoutManager = GridLayoutManager(this, 3)  // 포켓몬 한 줄에 3개
    }

    private fun initPokemonList() {
        pokemonDatas.apply {
            add(Pokemon("0001", "이상해씨",
                R.drawable.img_bulbasaur,
                ContextCompat.getColor(this@MainActivity, R.color.grass_background),
                PokemonType.GRASS,
                PokemonType.POISON))
            add(Pokemon("0002", "이상해풀",
                R.drawable.img_ivysaur,
                ContextCompat.getColor(this@MainActivity, R.color.grass_background),
                PokemonType.GRASS,
                PokemonType.POISON))
            add(Pokemon("0003", "이상해꽃",
                R.drawable.img_venusaur,
                ContextCompat.getColor(this@MainActivity, R.color.grass_background),
                PokemonType.GRASS,
                PokemonType.POISON))
            add(Pokemon("0004", "파이리",
                R.drawable.img_charmander,
                ContextCompat.getColor(this@MainActivity, R.color.fire_background),
                PokemonType.FIRE,
                null))
            add(Pokemon("0005", "리자드",
                R.drawable.img_charmeleon,
                ContextCompat.getColor(this@MainActivity, R.color.fire_background),
                PokemonType.FIRE,
                null))
            add(Pokemon("0006", "리자몽",
                R.drawable.img_charizard,
                ContextCompat.getColor(this@MainActivity, R.color.fire_background),
                PokemonType.FIRE,
                PokemonType.FLYING))
            add(Pokemon("0007", "꼬부기",
                R.drawable.img_squirtle,
                ContextCompat.getColor(this@MainActivity, R.color.water_background),
                PokemonType.WATER,
                null))
            add(Pokemon("0008", "어니부기",
                R.drawable.img_wartortle,
                ContextCompat.getColor(this@MainActivity, R.color.water_background),
                PokemonType.WATER,
                null))
            add(Pokemon("0009", "거북왕",
                R.drawable.img_blastoise,
                ContextCompat.getColor(this@MainActivity, R.color.water_background),
                PokemonType.WATER,
                null))
            add(Pokemon("0010", "캐터피",
                R.drawable.img_caterpie,
                ContextCompat.getColor(this@MainActivity, R.color.bug_background),
                PokemonType.BUG,
                null))
            add(Pokemon("0011", "단데기",
                R.drawable.img_metapod,
                ContextCompat.getColor(this@MainActivity, R.color.bug_background),
                PokemonType.BUG,
                null))
            add(Pokemon("0012", "버터플",
                R.drawable.img_butterfree,
                ContextCompat.getColor(this@MainActivity, R.color.bug_background),
                PokemonType.BUG,
                PokemonType.FLYING))
            add(Pokemon("0013", "뿔충이",
                R.drawable.img_weedle,
                ContextCompat.getColor(this@MainActivity, R.color.bug_background),
                PokemonType.BUG,
                PokemonType.POISON))
            add(Pokemon("0014", "딱충이",
                R.drawable.img_kakuna,
                ContextCompat.getColor(this@MainActivity, R.color.bug_background),
                PokemonType.BUG,
                PokemonType.POISON))
            add(Pokemon("0015", "독침봉",
                R.drawable.img_beedrill,
                ContextCompat.getColor(this@MainActivity, R.color.bug_background),
                PokemonType.BUG,
                PokemonType.POISON))
        }
    }
}