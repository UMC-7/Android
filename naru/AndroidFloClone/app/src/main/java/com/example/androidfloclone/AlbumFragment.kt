package com.example.androidfloclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidfloclone.databinding.FragmentAlbumBinding
import com.google.android.material.tabs.TabLayoutMediator

class AlbumFragment : Fragment() {
    lateinit var binding: FragmentAlbumBinding

    private val information = arrayListOf("수록곡", "상세정보", "영상")

    private var singer: String? = null  // 가수 이름을 저장할 변수

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater,container,false)

        // 전달받은 데이터 가져오기
        arguments?.let {
            singer = it.getString("singer") ?: "Unknown Singer"
            val albumName = it.getString("albumName") ?: "Unknown Album"

            // 텍스트뷰애 앨범이름과 가수 설정
            binding.albumMusicTitleTv.text = albumName
            binding.albumSingerNameTv.text = singer
        }

        binding.albumBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm,HomeFragment())
                .commitAllowingStateLoss()
        }

        // 앨범 어댑터 초기화
        val albumAdapter = AlbumVPAdapter(this, singer)
        binding.albumContentVp.adapter = albumAdapter

        TabLayoutMediator(binding.albumContentTb, binding.albumContentVp) {
            tap, position ->
            tap.text = information[position]
        }.attach()

        return binding.root
    }
}