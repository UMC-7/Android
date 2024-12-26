package com.example.clone_coding

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clone_coding.databinding.ItemLockerSongBinding

class AlbumLockerRVAdapter(private val albumList : ArrayList<Album>): RecyclerView.Adapter<AlbumLockerRVAdapter.ViewHolder>() {
    interface MyItemClickListener{
        fun onRemoveSong(position: Int)
    }

    private lateinit var myItemClickListener: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        myItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AlbumLockerRVAdapter.ViewHolder {
        val binding: ItemLockerSongBinding = ItemLockerSongBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumLockerRVAdapter.ViewHolder, position: Int) {
        val item = albumList[position] // 현재 아이템

        holder.bind(item)
        holder.binding.itemSongMoreIv.setOnClickListener {
            myItemClickListener.onRemoveSong(position)
        }
    }

    override fun getItemCount(): Int = albumList.size

    fun removeSong(position: Int){
        albumList.removeAt(position)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemLockerSongBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(album: Album) {
            // 기본 데이터 바인딩
            binding.itemSongImgIv.setImageResource(album.coverimg!!)
            binding.itemSongTitleTv.text = album.title
            binding.itemSongSingerTv.text = album.singer

            // Switch 상태를 데이터 모델 값으로 설정
            binding.itemSwitch.apply {
                setOnCheckedChangeListener(null) // 기존 리스너 초기화
                isChecked = album.isSwitchOn

                // Switch 상태 변경 리스너 설정
                setOnCheckedChangeListener { _, isChecked ->
                    album.isSwitchOn = isChecked
                }
            }
        }
    }

}