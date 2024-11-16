package com.example.androidfloclone

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.util.getOrDefault
import androidx.core.util.set
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfloclone.databinding.ItemAlbumBinding
import com.example.androidfloclone.databinding.ItemSavedSongBinding

class SavedSongRVAdapter(private val albumList: ArrayList<Album>): RecyclerView.Adapter<SavedSongRVAdapter.ViewHolder>() {

    interface MyItemClickListener {
        fun onItemClick(album: Album)
        fun onRemoveAlbum(position: Int)
    }

    private lateinit var myItemClickListener: MyItemClickListener
    private val switchStatus = SparseBooleanArray()

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

    override fun getItemCount(): Int = albumList.size

    inner class ViewHolder(val binding: ItemSavedSongBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(album: Album) {
            binding.itemSavedSongTitleTv.text = album.title
            binding.itemSavedSongSingerTv.text = album.singer
            binding.itemSavedSongAlbumCoverImgIv.setImageResource(album.coverImg!!)
        }
    }
}