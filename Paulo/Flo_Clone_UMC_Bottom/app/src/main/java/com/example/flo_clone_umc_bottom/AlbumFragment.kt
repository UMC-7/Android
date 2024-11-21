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
import com.google.gson.Gson

class AlbumFragment : Fragment() {
    lateinit var binding : FragmentAlbumBinding
    private var information = arrayListOf("수록곡","상세정보","영상")
    private var gson: Gson = Gson()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater, container,false)

        val albumJson = arguments?.getString("album")
        val album = gson.fromJson(albumJson, Album::class.java)
        setInit(album)

        binding.albumBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_frm,HomeFragment()).commitAllowingStateLoss()
        }

//        val albumTitle = arguments?.getString("ALBUM_TITLE")
//        val albumArtist = arguments?.getString("ALBUM_ARTIST")
//        val albumImageResId = arguments?.getInt("ALBUM_IMAGE")

        val albumAdapter = AlbumVPAdapter(this, album.title, album.singer)
        binding.albumContentVp.adapter = albumAdapter
        TabLayoutMediator(binding.albumContentTb, binding.albumContentVp){
            tab, position ->
            tab.text = information[position]
        }.attach()

//        binding.albumMusicTitleTv.text = album.title ?: "Unknown Album"
//        binding.albumSingerNameTv.text = album.singer ?: "Unknown Artist"
//        albumImageResId?.let { binding.albumAlbumIv.setImageResource(it) }
//
        val formattedTitle = String.format("%s 5th Album '%s'", album.singer,album.title)
        binding.albumMusicTitleTv.text = formattedTitle
        return binding.root
    }

    private fun setInit(album: Album){
        binding.albumAlbumIv.setImageResource(album.coverImg!!)
    }

}