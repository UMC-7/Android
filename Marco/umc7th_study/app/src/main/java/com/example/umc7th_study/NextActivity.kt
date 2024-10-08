package com.example.umc7th_study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.umc7th_study.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNextBinding

    // 현재 좌표 파악용 (프래그먼트)
    var cur = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding 초기화
        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 뒤로가기 아이콘 클릭시 NextActivity 종료 (생명주기)
        binding.nextBackIv.setOnClickListener {
            finish()
        }

        // 선택된 좌표 저장
        cur = intent.getIntExtra("id", 1)

        // 바텀 네비게이션 뷰 작동
        initBottomNavigation(cur)
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
                    switchFragment(HomeFragment(), 1)
                    return@setOnItemSelectedListener true
                }
                R.id.fragment_search -> {
                    switchFragment(SearchFragment(), 2)
                    return@setOnItemSelectedListener true
                }
                R.id.fragment_calender -> {
                    switchFragment(CalenderFragment(), 3)
                    return@setOnItemSelectedListener true
                }
                R.id.fragment_profile -> {
                    switchFragment(ProfileFragment(), 4)
                    return@setOnItemSelectedListener true
                }
                else -> false
            }
        }
    }

    fun switchFragment(fragment: Fragment, dest: Int) {
        if(cur == dest) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.next_container_fl, fragment)
                .commitAllowingStateLoss()
        }
        else if(cur > dest) {
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_enter_from_left, R.anim.slide_exit_to_right)
                .replace(R.id.next_container_fl, fragment)
                .commitAllowingStateLoss()
        }
        else if(cur < dest) {
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_enter_from_right, R.anim.slide_exit_to_left)
                .replace(R.id.next_container_fl, fragment)
                .commitAllowingStateLoss()
        }
        cur = dest
    }
}