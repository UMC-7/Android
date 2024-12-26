package com.example.androidfloclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidfloclone.databinding.FragmentSongBinding

class SongFragment : Fragment() {
    lateinit var binding: FragmentSongBinding
    private lateinit var singer: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongBinding.inflate(inflater, container, false)

        singer = arguments?.getString("singer") ?: "Unknown Singer"

        // 가수 이름을 여러 TextView에 설정하기
        val singerTextViews = listOf(
            binding.songSingerName01Tv,
            binding.songSingerName02Tv,
            binding.songSingerName03Tv,
            binding.songSingerName04Tv,
            binding.songSingerName05Tv,
            binding.songSingerName06Tv,
            binding.songSingerName07Tv,
            binding.songSingerName08Tv,
            binding.songSingerName09Tv,
            binding.songSingerName10Tv
        )

        // 내 취향 버튼 이미지 변경
        binding.songMixoffTg.setOnClickListener {
            binding.songMixoffTg.visibility = View.GONE
            binding.songMixonTg.visibility = View.VISIBLE
        }
        binding.songMixonTg.setOnClickListener {
            binding.songMixoffTg.visibility = View.VISIBLE
            binding.songMixonTg.visibility = View.GONE
        }

        // 각 TextView에 가수 이름 설정
        singerTextViews.forEach { textView ->
            textView.text = singer
        }

        return binding.root
    }
}