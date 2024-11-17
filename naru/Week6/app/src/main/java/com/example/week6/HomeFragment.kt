package com.example.week6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.week6.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeVPAdapter: HomeVPAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)
        homeVPAdapter = HomeVPAdapter(requireActivity())

        // ViewPager2 설정
        binding.homeVp.adapter = homeVPAdapter

        // TabLayout과 ViewPager2 연결
        TabLayoutMediator(binding.homeTb, binding.homeVp) { tab, position ->
            when (position) {
                0 -> tab.text = "추천"
                1 -> tab.text = "랭킹"
                2 -> tab.text = "세일"
                3 -> tab.text = "브랜드"
                4 -> tab.text = "신상"
            }
        }.attach()
    }
}
