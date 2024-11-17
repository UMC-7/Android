package com.example.week6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
    }

    private fun initBottomNavigation() {

        // 기본 프래그먼트로 홈 프래그먼트를 표시
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()

        binding.mainBnv.selectedItemId = R.id.homeFragment

        binding.mainBnv.setOnItemSelectedListener { item ->
            when (item.itemId) {

                // 카테고리 프래그먼트
                R.id.categoryFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, CategoryFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                // 스냅 프래그먼트
                R.id.snapFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, SnapFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                // 홈 프래그먼트
                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                // 좋아요 프래그먼트
                R.id.likeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, LikeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                // 마이 프래그먼트
                R.id.myFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, MyFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}
