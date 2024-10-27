package com.example.flo_clone_umc_bottom

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class AlbumVPAdapter(fragment: Fragment, private val albumTitle: String?,
                     private val albumArtist: String?):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment {
        val fragment =  when (position) {
            0 -> SongVPFragment()
            1 -> DetailFragment()
            else -> VideoFragment()
        }
        if (fragment is SongVPFragment) {
            val bundle = Bundle().apply {
                putString("ALBUM_TITLE", albumTitle)
                putString("ALBUM_ARTIST", albumArtist)
            }
            fragment.arguments = bundle
        }
        return fragment
    }
}