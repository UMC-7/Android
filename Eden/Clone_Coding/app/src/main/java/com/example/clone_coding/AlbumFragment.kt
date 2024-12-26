package com.example.clone_coding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clone_coding.databinding.FragmentAlbumBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson

class AlbumFragment() : Fragment() {
    lateinit var binding: FragmentAlbumBinding
    private var gson: Gson = Gson()
    private var information = arrayListOf("수록곡", "상세정보", "영상")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater, container, false)

        //앨범 데이터 받아오기
        val albumJson = arguments?.getString("album")
        val album = gson.fromJson(albumJson, Album::class.java)
        setInit(album)

//        // Bundle에서 데이터 가져오기
//        val albumTitle = arguments?.getString("albumTitle")
//        val singer = arguments?.getString("singer")
//        val info = arguments?.getString("info")
//        val img = arguments?.getInt("img")
//
//        // UI에 데이터 설정
//        binding.albumMusicTitleTv.text = albumTitle
//        binding.albumSingerNameTv.text = singer
//        binding.albumMusicTitleInfoTv.text = info
//
//        // ImageView에 이미지 리소스를 설정
//        img?.let {
//            if (it != 0) {
//                binding.albumAlbumIv.setImageResource(it)
//            }
//        }

        //뒤로가기 버튼 액션
        binding.albumBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm , HomeFragment())
                .commitAllowingStateLoss()
        }


        val albumAdapter = AlbumVPAdapter(this)
        binding.albumContentVp.adapter = albumAdapter

        TabLayoutMediator(binding.albumContentTb, binding.albumContentVp){
            tab, position -> tab.text = information[position]
        }.attach()


        return binding.root
    }

    private fun setInit(album: Album) {
        binding.albumAlbumIv.setImageResource(album.coverimg!!)
        binding.albumMusicTitleTv.text = album.title.toString()
        binding.albumSingerNameTv.text = album.singer.toString()

    }


}