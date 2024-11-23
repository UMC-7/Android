package com.example.androidfloclone

import android.annotation.SuppressLint
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.util.getOrDefault
import androidx.core.util.set
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfloclone.databinding.ItemSavedSongBinding

class SavedSongRVAdapter(): RecyclerView.Adapter<SavedSongRVAdapter.ViewHolder>() {
    private val songs = ArrayList<Song>()
    private val switchStatus = SparseBooleanArray()

    interface MyItemClickListener {
        fun onRemoveSong(songId: Int)
    }

    private lateinit var myItemClickListener: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener) {
        myItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SavedSongRVAdapter.ViewHolder {
        val binding: ItemSavedSongBinding = ItemSavedSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedSongRVAdapter.ViewHolder, position: Int) {
        holder.bind(songs[position])
        holder.binding.itemSavedSongMoreIv.setOnClickListener {
            myItemClickListener.onRemoveSong(songs[position].id)
            removeSongs(position)
        }

        val switch = holder.binding.itemSavedSongSwitch
        // switch 상태 초기화: Map에서 가져오기, 기본값은 false
        switch.isChecked = switchStatus.getOrDefault(position, false)

        switch.setOnClickListener {
            // 스위치 상태 변경
            switchStatus[position] = switch.isChecked
            // 상태가 변경된 항목 갱신
            notifyItemChanged(position)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addSongs(songs: ArrayList<Song>) {
        this.songs.clear()
        this.songs.addAll(songs)

        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun removeSongs(position: Int){
        songs.removeAt(position)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = songs.size

    inner class ViewHolder(val binding: ItemSavedSongBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(album: Song) {
            binding.itemSavedSongTitleTv.text = album.title
            binding.itemSavedSongSingerTv.text = album.singer
            binding.itemSavedSongAlbumCoverImgIv.setImageResource(album.coverImg!!)
        }
    }
}