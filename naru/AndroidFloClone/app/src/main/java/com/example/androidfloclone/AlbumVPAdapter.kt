package com.example.androidfloclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class AlbumVPAdapter(fragment: Fragment, private val singer: String?) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> SongFragment().apply {
                arguments = Bundle().apply {
                    putString("singer", singer)
                }
            }
            1 -> DetailFragment()
            else -> VideoFragment()
        }
    }
}