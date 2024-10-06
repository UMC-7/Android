package com.example.umc7th_study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc7th_study.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding 초기화
        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 뒤로가기 아이콘 클릭시 NextActivity 종료 (생명주기)
        binding.nextBackIv.setOnClickListener {
            finish()
        }

        // 바텀 네비게이션 뷰 작동
        initBottomNavigation(intent.getIntExtra("id", 1))
    }


    private fun initBottomNavigation(id : Int) {
        when (id) {
            1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.next_container_fl, HomeFragment())
                    .commitAllowingStateLoss()
                binding.nextBottomNav.selectedItemId = R.id.fragment_home
            }
            2 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.next_container_fl, SearchFragment())
                    .commitAllowingStateLoss()
                binding.nextBottomNav.selectedItemId = R.id.fragment_search
            }
            3 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.next_container_fl, CalenderFragment())
                    .commitAllowingStateLoss()
                binding.nextBottomNav.selectedItemId = R.id.fragment_calender
            }
            4 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.next_container_fl, ProfileFragment())
                    .commitAllowingStateLoss()
                binding.nextBottomNav.selectedItemId = R.id.fragment_profile
            }
        }

        binding.nextBottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragment_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.next_container_fl, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.fragment_search -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.next_container_fl, SearchFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.fragment_calender -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.next_container_fl, CalenderFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.fragment_profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.next_container_fl, ProfileFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                else -> false
            }
        }
    }
}