package com.example.clone_coding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clone_coding.databinding.FragmentSavedSongBinding

class SavedSongFragment : Fragment() {
    private lateinit var binding : FragmentSavedSongBinding
    private var lockerAlbumDatas = ArrayList<Album>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSavedSongBinding.inflate(inflater, container, false)

        lockerAlbumDatas.apply {
            add(Album("처음", "두둥탁", R.drawable.img_phj_poster))
            add(Album("로고", "두둥탁", R.drawable.img_phj_logo))
            add(Album("엄", "엄헌준", R.drawable.img_phj_um))
            add(Album("Champagne Supernova", "피아노헌준", R.drawable.img_phj_piano))
            add(Album("정류장에서", "마스크헌준", R.drawable.img_phj_bus))
            add(Album("나도 졸업하고 싶다", "20박헌준", R.drawable.img_phj_good))
        }

        var albumLockerRVAdapter = AlbumLockerRVAdapter(lockerAlbumDatas)
        binding.lockerSavedSongRecyclerView.adapter = albumLockerRVAdapter
        binding.lockerSavedSongRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        albumLockerRVAdapter.setMyItemClickListener(object : AlbumLockerRVAdapter.MyItemClickListener{
            override fun onRemoveSong(position: Int) {
                albumLockerRVAdapter.removeSong(position)
            }

        })



        return binding.root
    }
}