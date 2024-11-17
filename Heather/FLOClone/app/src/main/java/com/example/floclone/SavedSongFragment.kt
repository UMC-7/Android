package com.example.floclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.floclone.databinding.FragmentSavedSongBinding


class SavedSongFragment : Fragment() {

//    private var albumDatas = ArrayList<Album>()
    lateinit var binding : FragmentSavedSongBinding
    private var songDatas = ArrayList<Song>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSavedSongBinding.inflate(inflater, container, false)

        // 더미데이터 생성
        songDatas.apply {
            add(Song("Whiplash", "aespa", 0, 180, false, "whiplash", coverImg = R.drawable.img_album_exp7))
            add(Song("APT.", "로제 (ROSÉ) & Bruno Mars", 0, 180, false, "apt", coverImg = R.drawable.img_album_exp8))
            add(Song("HAPPY", "DAY6 (데이식스)", 0, 180, false, "happy", coverImg = R.drawable.img_album_exp9))
            add(Song("POWER", "G-DRAGON", 0, 180, false, "power", coverImg = R.drawable.img_album_exp10))
            add(Song("UP (KARINA Solo)", "aespa", 0, 180, false, "up", coverImg = R.drawable.img_album_exp11))
            add(Song("Drowning", "WOODZ", 0, 180, false, "drowning", coverImg = R.drawable.img_album_exp12))
            add(Song("내 이름 맑음", "QWER", 0, 180, false, "qwer", coverImg = R.drawable.img_album_exp13))
            add(Song("Welcome to the show", "DAY6 (데이식스)", 0, 180, false, "welcomeToTheShow", coverImg = R.drawable.img_album_exp9))
        }

        val songRVAdapter = SongRVAdapter(songDatas)
        binding.savedSongRv.apply {
            adapter = songRVAdapter
            layoutManager = LinearLayoutManager(context)
        }

        return binding.root
    }

}