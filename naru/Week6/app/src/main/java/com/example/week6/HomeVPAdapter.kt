package com.example.week6

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeVPAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> RecommendedFragment()  // 추천 탭
            1 -> RankingFragment()      // 랭킹 탭
            2 -> SaleFragment()         // 세일 탭
            3 -> BrandFragment()        // 브랜드 탭
            4 -> NewArrivalsFragment()  // 신상 탭
            else -> throw IllegalStateException("Invalid position")
        }
    }
}