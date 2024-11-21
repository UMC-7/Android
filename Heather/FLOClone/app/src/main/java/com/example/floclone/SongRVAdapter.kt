package com.example.floclone

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.floclone.databinding.ItemSongBinding

class SongRVAdapter(private val songs: ArrayList<Song>) :
    RecyclerView.Adapter<SongRVAdapter.ViewHolder>() {

    // 클릭 인터페이스 정의
    interface MyItemClickListener {
        fun onRemoveSong(position: Int)
    }

    private lateinit var mItemClickListener: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener) {
        mItemClickListener = itemClickListener
    }

    // 아이템 삭제
    fun removeSong(position: Int) {
        songs.removeAt(position)
        notifyDataSetChanged()
    }

    // 뷰 홀더
    inner class ViewHolder(private val binding: ItemSongBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(song: Song) {
            binding.itemSongTitleTv.text = song.title
            binding.itemSongSingerTv.text = song.singer

            // 앨범 이미지 설정 (null이 아닐 때만)
            song.coverImg?.let { coverImg ->
                binding.itemSongAlbumIv.setImageResource(coverImg)
            }

            // 더보기 버튼 클릭 리스너 설정
            binding.itemSongMoreIv.setOnClickListener {
                mItemClickListener.onRemoveSong(adapterPosition)
            }

            // 스위치 상태 설정
            binding.itemSongSwitch.isChecked = song.isSwitchOn

            // 스위치 상태 변경 리스너
            binding.itemSongSwitch.setOnCheckedChangeListener { _, isChecked ->
                song.isSwitchOn = isChecked
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