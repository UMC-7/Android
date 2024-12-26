package com.example.androidfloclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class AlbumVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    // 프래그먼트의 개수를 반환
    override fun getItemCount(): Int = 3

    // 주어진 위치에 해당하는 프래그먼트를 생성하여 반환
    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> SongFragment()
                /* private val singer: String?
                .apply {
                arguments = Bundle().apply {
                    putString("singer", singer)
                }
            }*/
            1 -> DetailFragment()
            else -> VideoFragment()
        }
    }
}
