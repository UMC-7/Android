package com.example.androidfloclone

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PanelVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    // 프래그먼트를 저장하는 리스트
    private val fragmentList: ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int = fragmentList.size

    // 해당 위치의 프래그먼트를 반환
    override fun createFragment(position: Int): Fragment = fragmentList[position]

    // 프래그먼트를 리스트에 추가하고 새 아이템이 삽입됨을 알림
    fun addFragment(fragment: Fragment) {
        fragmentList.add(fragment)
        notifyItemInserted(fragmentList.size - 1)
    }
}
