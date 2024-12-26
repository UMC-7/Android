package com.example.clone_coding

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PannerVPAdapter(fragment : Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->HomePanel1Fragment()
            1->HomePanel2Fragment()
            else->HomePanel3Fragment()
        }
    }
}