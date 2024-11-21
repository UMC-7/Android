package com.example.flo_clone_umc_bottom

import android.util.Log
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.flo_clone_umc_bottom.databinding.ItemAlbumBinding
import com.example.flo_clone_umc_bottom.databinding.ItemSavedBinding

class LockerAlbumRVAdapter(private val savedList: ArrayList<LockerAlbum>):RecyclerView.Adapter<LockerAlbumRVAdapter.ViewHolder>() {

    private val switchStatus = SparseBooleanArray()

    interface MyItemClickListener{
        //fun onItemClick(lockerAlbum: LockerAlbum)
        fun onRemoveAlbum(position: Int)
        fun onButtonClick(position: Int, click: Boolean)
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
        holder.binding.itemSavedSwitchSw.isChecked = switchStatus.get(position, false)

        holder.bind(savedList[position])
        holder.binding.itemSavedMoreIv.setOnClickListener{
            mItemClickListener.onRemoveAlbum(position)
        }
        //6주차 ... 누르면 없어지기

        holder.binding.itemSavedPlayIv.setOnClickListener {
            savedList[position].isButtonVisible = false
            mItemClickListener.onButtonClick(position, savedList[position].isButtonVisible)
            notifyItemChanged(position)
        }

        holder.binding.itemSavedPauseIv.setOnClickListener {
            savedList[position].isButtonVisible = true
            mItemClickListener.onButtonClick(position, savedList[position].isButtonVisible)
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int = savedList.size

    inner class ViewHolder(val binding: ItemSavedBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(lockerAlbum:LockerAlbum){
            binding.itemSavedTitleTv.text = lockerAlbum.title
            binding.itemSavedSingerTv.text = lockerAlbum.title
            binding.itemSavedImgIv.setImageResource(lockerAlbum.coverImg!!)

            if (lockerAlbum.isButtonVisible) {
                binding.itemSavedPlayIv.visibility = View.GONE
                binding.itemSavedPauseIv.visibility = View.VISIBLE
            } else {
                binding.itemSavedPlayIv.visibility = View.VISIBLE
                binding.itemSavedPauseIv.visibility = View.GONE
            }

            binding.itemSavedSwitchSw.setOnCheckedChangeListener(null)
            binding.itemSavedSwitchSw.isChecked = switchStatus.get(bindingAdapterPosition, false)

            binding.itemSavedSwitchSw.setOnCheckedChangeListener { _, isChecked ->
                switchStatus.put(bindingAdapterPosition, isChecked)
            }
            //6주차 스위치 상태 저장
        }
    }
}