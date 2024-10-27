package com.example.flo_clone_umc_bottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.flo_clone_umc_bottom.databinding.FragmentAlbumBinding
import com.google.android.material.tabs.TabLayoutMediator

class AlbumFragment : Fragment() {
    lateinit var binding : FragmentAlbumBinding
    private var information = arrayListOf("수록곡","상세정보","영상")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater, container,false)

        binding.albumBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_frm,HomeFragment()).commitAllowingStateLoss()
        }

        val albumTitle = arguments?.getString("ALBUM_TITLE")
        val albumArtist = arguments?.getString("ALBUM_ARTIST")
        val albumImageResId = arguments?.getInt("ALBUM_IMAGE")

        val albumAdapter = AlbumVPAdapter(this, albumTitle, albumArtist)
        binding.albumContentVp.adapter = albumAdapter
        TabLayoutMediator(binding.albumContentTb, binding.albumContentVp){
            tab, position ->
            tab.text = information[position]
        }.attach()

//        binding.albumMusicTitleTv.text = albumTitle ?: "Unknown Album"
//        binding.albumSingerNameTv.text = albumArtist ?: "Unknown Artist"
          albumImageResId?.let { binding.albumAlbumIv.setImageResource(it) }
//
//        val formattedTitle = String.format("%s 5th Album '%s'", albumArtist,albumTitle)
//        binding.albumMusicTitleTv.text = formattedTitle
        return binding.root
    }
}