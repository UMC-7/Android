package com.example.floclone

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.floclone.databinding.ItemSongBinding

class SongRVAdapter(private val songs: ArrayList<Song>) :
    RecyclerView.Adapter<SongRVAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemSongBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(song: Song) {
            binding.itemSongTitleTv.text = song.title
            binding.itemSongSingerTv.text = song.singer

            // 앨범 이미지 설정 (null이 아닐 때만)
            song.coverImg?.let { coverImg ->
                binding.itemSongAlbumIv.setImageResource(coverImg)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSongBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(songs[position])
    }

    override fun getItemCount(): Int = songs.size
}