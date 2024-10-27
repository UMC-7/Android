package com.example.androidfloclone

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PannelVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val fragmentList: ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]

    fun addFragment(fragment: Fragment) {
        fragmentList.add(fragment)
        notifyItemInserted(fragmentList.size - 1)
    }
}
