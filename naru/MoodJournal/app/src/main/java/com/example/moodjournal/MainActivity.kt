package com.example.moodjournal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moodjournal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰 바인딩 객체 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 이미지 클릭 시 MoodQuestionsActivity로 이동
        binding.ivMoodHappy.setOnClickListener {
            startActivity(Intent(this, MoodQuestionsActivity::class.java))
        }

        binding.ivMoodExcited.setOnClickListener {
            startActivity(Intent(this, MoodQuestionsActivity::class.java))
        }

        binding.ivMoodNormal.setOnClickListener {
            startActivity(Intent(this, MoodQuestionsActivity::class.java))
        }

        binding.ivMoodAnxious.setOnClickListener {
            startActivity(Intent(this, MoodQuestionsActivity::class.java))
        }

        binding.ivMoodAngry.setOnClickListener {
            startActivity(Intent(this, MoodQuestionsActivity::class.java))
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    finish() // 홈 화면에서는 백스택을 사용하지 않고 바로 메인 액티비티 시작
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }

                R.id.nav_diary_list -> {
                    supportFragmentManager.beginTransaction()
                        .setCustomAnimations(
                            R.anim.from_right, // 새 프래그먼트가 오른쪽에서 나타날 때
                            R.anim.to_left,     // 기존 프래그먼트가 왼쪽으로 사라질 때
                            R.anim.from_left,  // 뒤로 갈 때 새 프래그먼트가 왼쪽에서 나타날 때
                            R.anim.to_right     // 뒤로 갈 때 기존 프래그먼트가 오른쪽으로 사라질 때
                        )
                        .replace(R.id.fragment_container_view, JournalListFragment())
                        .addToBackStack(null) // 백스택에 추가
                        .commit()
                    true
                }

                R.id.nav_mood_history -> {
                    supportFragmentManager.beginTransaction()
                        .setCustomAnimations(
                            R.anim.from_right,
                            R.anim.to_left,
                            R.anim.from_left,
                            R.anim.to_right
                        )
                        .replace(R.id.fragment_container_view, MoodHistoryFragment())
                        .addToBackStack(null) // 백스택에 추가
                        .commit()
                    true
                }

                R.id.nav_my_page -> {
                    supportFragmentManager.beginTransaction()
                        .setCustomAnimations(
                            R.anim.from_right,
                            R.anim.to_left,
                            R.anim.from_left,
                            R.anim.to_right
                        )
                        .replace(R.id.fragment_container_view, MyPageFragment())
                        .addToBackStack(null) // 백스택에 추가
                        .commit()
                    true
                }
                else -> false
            }
        }

    }
}
