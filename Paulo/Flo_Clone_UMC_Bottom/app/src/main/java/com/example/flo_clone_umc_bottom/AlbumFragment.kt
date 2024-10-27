package com.example.flo_clone_umc_bottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.flo_clone_umc_bottom.databinding.FragmentAlbumBinding

class AlbumFragment : Fragment() {
    lateinit var binding : FragmentAlbumBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater, container,false)

        binding.albumBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_frm,HomeFragment()).commitAllowingStateLoss()
        }

        binding.songMixoffTg.setOnClickListener {
            setMixStatus(true)
        }
        binding.songMixonTg.setOnClickListener {
            setMixStatus(false)
        }

        val albumTitle = arguments?.getString("ALBUM_TITLE")
        val albumArtist = arguments?.getString("ALBUM_ARTIST")
        val albumImageResId = arguments?.getInt("ALBUM_IMAGE")

        binding.albumMusicTitleTv.text = albumTitle ?: "Unknown Album"
        binding.albumSingerNameTv.text = albumArtist ?: "Unknown Artist"
        albumImageResId?.let { binding.albumAlbumIv.setImageResource(it) }

        val formattedTitle = String.format("%s 5th Album '%s'", albumArtist,albumTitle)
        binding.albumMusicTitleTv.text = formattedTitle


        binding.songMusicTitle01Tv.text = albumTitle ?: "Unknown Album"
        binding.songSingerName01Tv.text = albumArtist ?: "Unknown Artist"

        binding.songLalacLayout.setOnClickListener {
            Toast.makeText(activity,albumTitle,Toast.LENGTH_SHORT).show()
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