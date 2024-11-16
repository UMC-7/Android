package com.example.androidfloclone

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfloclone.databinding.ItemAlbumBinding
import com.example.androidfloclone.databinding.ItemSavedSongBinding

class SavedSongRVAdapter(private val albumList: ArrayList<Album>): RecyclerView.Adapter<SavedSongRVAdapter.ViewHolder>() {

    interface MyItemClickListener {
        fun onItemClick(album: Album)
        fun onRemoveAlbum(position: Int)
    }

    private lateinit var myItemClickListener: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener) {
        myItemClickListener = itemClickListener
    }

    fun addItem(album: Album) {
        albumList.add(album)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        albumList.removeAt(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SavedSongRVAdapter.ViewHolder {
        val binding: ItemSavedSongBinding = ItemSavedSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedSongRVAdapter.ViewHolder, position: Int) {
        holder.bind(albumList[position])

        holder.itemView.setOnClickListener{
            myItemClickListener.onItemClick(albumList[position])
        }
        holder.binding.itemSavedSongMoreIv.setOnClickListener {
            myItemClickListener.onRemoveAlbum(position)
        }
    }

    override fun getItemCount(): Int = albumList.size

    inner class ViewHolder(val binding: ItemSavedSongBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(album: Album) {
            binding.itemSavedSongTitleTv.text = album.title
            binding.itemSavedSongSingerTv.text = album.singer
            binding.itemSavedSongAlbumCoverImgIv.setImageResource(album.coverImg!!)
        }
    }
}