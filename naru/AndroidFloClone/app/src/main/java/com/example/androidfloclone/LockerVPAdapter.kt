package com.example.androidfloclone

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class LockerVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    // 프래그먼트의 개수를 반환
    override fun getItemCount(): Int = 3

    // 주어진 위치에 해당하는 프래그먼트를 생성하여 반환
    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> SavedSongFragment()
            1 -> MusicFileFragment()
            else -> SavedAlbumFragment()
        }
    }
}