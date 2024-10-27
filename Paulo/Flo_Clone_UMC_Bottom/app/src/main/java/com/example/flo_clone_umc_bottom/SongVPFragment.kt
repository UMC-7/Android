package com.example.flo_clone_umc_bottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.flo_clone_umc_bottom.databinding.FragmentDetailBinding
import com.example.flo_clone_umc_bottom.databinding.FragmentSongvpBinding

class SongVPFragment : Fragment() {
    lateinit var binding: FragmentSongvpBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongvpBinding.inflate(inflater,container,false)
        //내 취향 믹스 버튼 온 오프
        binding.songMixoffTg.setOnClickListener {
            setMixStatus(true)
        }
        binding.songMixonTg.setOnClickListener {
            setMixStatus(false)
        }

        val albumTitle = arguments?.getString("ALBUM_TITLE")
        val albumArtist = arguments?.getString("ALBUM_ARTIST")

        binding.songMusicTitle01Tv.text = albumTitle ?: "Unknown Album"
        binding.songSingerName01Tv.text = albumArtist ?: "Unknown Artist"

        binding.songLalacLayout.setOnClickListener {
            Toast.makeText(activity,albumTitle, Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

    fun setMixStatus(isPlaying : Boolean) {
        if (isPlaying) {
            binding.songMixoffTg.visibility = View.GONE
            binding.songMixonTg.visibility = View.VISIBLE
        } else {
            binding.songMixoffTg.visibility = View.VISIBLE
            binding.songMixonTg.visibility = View.GONE
        }
    }
}