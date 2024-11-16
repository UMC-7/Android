package com.example.androidfloclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidfloclone.databinding.FragmentSavedSongBinding
import com.google.gson.Gson

class SavedSongFragment : Fragment() {

    lateinit var binding: FragmentSavedSongBinding
    private var albumDatas = ArrayList<Album>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSavedSongBinding.inflate(inflater, container, false)

        albumDatas.apply {
            add(Album("Summer", "The Volunteers", R.drawable.img_album_exp2))
            add(Album("Drowning", "WOODZ", R.drawable.img_album_exp4))
            add(Album("Magnetic", "아일릿 (ILLIT)", R.drawable.img_album_exp5))
            add(Album("Butter", "방탄소년단 (BTS)", R.drawable.img_album_exp))
            add(Album("Next Level", "에스파 (AESPA)", R.drawable.img_album_exp3))
            add(Album("Weekend", "태연 (Tae Yeon)", R.drawable.img_album_exp6))
            add(Album("Summer", "The Volunteers", R.drawable.img_album_exp2))
            add(Album("Drowning", "WOODZ", R.drawable.img_album_exp4))
            add(Album("Magnetic", "아일릿 (ILLIT)", R.drawable.img_album_exp5))
            add(Album("Butter", "방탄소년단 (BTS)", R.drawable.img_album_exp))
            add(Album("Next Level", "에스파 (AESPA)", R.drawable.img_album_exp3))
            add(Album("Weekend", "태연 (Tae Yeon)", R.drawable.img_album_exp6))
            add(Album("Summer", "The Volunteers", R.drawable.img_album_exp2))
            add(Album("Drowning", "WOODZ", R.drawable.img_album_exp4))
            add(Album("Magnetic", "아일릿 (ILLIT)", R.drawable.img_album_exp5))
            add(Album("Butter", "방탄소년단 (BTS)", R.drawable.img_album_exp))
            add(Album("Next Level", "에스파 (AESPA)", R.drawable.img_album_exp3))
            add(Album("Weekend", "태연 (Tae Yeon)", R.drawable.img_album_exp6))
        }

        val savedSongRVAdapter = SavedSongRVAdapter(albumDatas)
        binding.savedSongAlbumRv.adapter = savedSongRVAdapter
        binding.savedSongAlbumRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        savedSongRVAdapter.setMyItemClickListener(object: SavedSongRVAdapter.MyItemClickListener {
            override fun onItemClick(album: Album) {
                changeAlbumFragment(album)
            }

            override fun onRemoveAlbum(position: Int) {
                savedSongRVAdapter.removeItem(position)
            }
        })

        return binding.root
    }

    private fun changeAlbumFragment(album: Album) {
        (context as MainActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, AlbumFragment().apply {
                arguments = Bundle().apply {
                    val gson = Gson()
                    val albumJson = gson.toJson(album)
                    putString("album", albumJson)
                }
            })
            .commitAllowingStateLoss()
    }
}