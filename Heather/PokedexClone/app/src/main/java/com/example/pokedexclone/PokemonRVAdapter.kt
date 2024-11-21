package com.example.pokedexclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexclone.databinding.ItemPokemonBinding

class PokemonRVAdapter(private val pokemons: ArrayList<Pokemon>) :
    RecyclerView.Adapter<PokemonRVAdapter.ViewHolder>() {

    interface MyItemClickListener {
        fun onTypeClick(position: Int)
    }

    private lateinit var mItemClickListener: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener) {
        mItemClickListener = itemClickListener
    }

    inner class ViewHolder(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(pokemon: Pokemon) {
            binding.itemPokemonIdTv.text = pokemon.id
            binding.itemPokemonNameTv.text = pokemon.name
            binding.itemPokemonImageIv.setImageResource(pokemon.image)
            binding.itemPokemonCv.setCardBackgroundColor(pokemon.backgroundColor)

            // 속성 버튼 설정
            if (pokemon.secondaryType != null) {
                binding.itemPokemonDualTypeLayout.visibility = View.VISIBLE
                binding.itemPokemonSingleTypeBtn.visibility = View.GONE

                binding.itemPokemonPrimaryTypeBtn.apply {
                    text = pokemon.primaryType.typeName
                    setBackgroundColor(ContextCompat.getColor(context, pokemon.primaryType.backgroundColor))
                }

                binding.itemPokemonSecondaryTypeBtn.apply {
                    text = pokemon.secondaryType.typeName
                    setBackgroundColor(ContextCompat.getColor(context, pokemon.secondaryType.backgroundColor))
                    visibility = View.VISIBLE
                }

            } else {
                // 단일 속성일 경우
                binding.itemPokemonDualTypeLayout.visibility = View.GONE
                binding.itemPokemonSingleTypeBtn.visibility = View.VISIBLE

                binding.itemPokemonSingleTypeBtn.apply {
                    text = pokemon.primaryType.typeName
                    setBackgroundColor(ContextCompat.getColor(context, pokemon.primaryType.backgroundColor))
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemPokemonBinding = ItemPokemonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pokemons[position])
    }

    override fun getItemCount(): Int = pokemons.size
}