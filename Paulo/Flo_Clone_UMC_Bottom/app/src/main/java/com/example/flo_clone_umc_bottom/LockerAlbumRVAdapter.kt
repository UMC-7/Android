package com.example.flo_clone_umc_bottom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flo_clone_umc_bottom.databinding.ItemAlbumBinding
import com.example.flo_clone_umc_bottom.databinding.ItemSavedBinding

class LockerAlbumRVAdapter(private val savedList: ArrayList<LockerAlbum>):RecyclerView.Adapter<LockerAlbumRVAdapter.ViewHolder>() {

    interface MyItemClickListener{
        //fun onItemClick(lockerAlbum: LockerAlbum)
        fun onRemoveAlbum(position: Int)
    }

    private lateinit var mItemClickListener: MyItemClickListener
    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListener = itemClickListener
    }

    fun removeItem(position: Int){
        savedList.removeAt(position)
        notifyDataSetChanged()
    }
    //6주차 ... 누르면 없어지기

    override fun onCreateViewHolder( viewGroup: ViewGroup, viewType: Int): LockerAlbumRVAdapter.ViewHolder {
        val binding: ItemSavedBinding = ItemSavedBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LockerAlbumRVAdapter.ViewHolder, position: Int) {
        holder.bind(savedList[position])
        holder.binding.itemSavedMoreIv.setOnClickListener{
            mItemClickListener.onRemoveAlbum(position)
        }
        //6주차 ... 누르면 없어지기
    }

    override fun getItemCount(): Int = savedList.size

    inner class ViewHolder(val binding: ItemSavedBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(lockerAlbum:LockerAlbum){
            binding.itemSavedTitleTv.text = lockerAlbum.title
            binding.itemSavedSingerTv.text = lockerAlbum.title
            binding.itemSavedImgIv.setImageResource(lockerAlbum.coverImg!!)
        }
    }
}