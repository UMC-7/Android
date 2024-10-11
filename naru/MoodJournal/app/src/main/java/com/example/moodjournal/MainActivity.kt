package com.example.moodjournal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.moodjournal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentSelectedItemId: Int = R.id.nav_home // 초기 선택된 아이템 ID

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

        // 바텀 네비게이션 아이템 선택 리스너
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // 홈 버튼이 눌렸을 때는 메인 액티비티를 다시 시작
                    val intent = Intent(this, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish() // 현재 액티비티 종료
                    true
                }

                R.id.nav_diary_list -> {
                    replaceFragment(JournalListFragment(), item.itemId > currentSelectedItemId)
                    currentSelectedItemId = item.itemId
                    true
                }

                R.id.nav_mood_history -> {
                    replaceFragment(MoodHistoryFragment(), item.itemId > currentSelectedItemId)
                    currentSelectedItemId = item.itemId
                    true
                }

                R.id.nav_my_page -> {
                    replaceFragment(MyPageFragment(), item.itemId > currentSelectedItemId)
                    currentSelectedItemId = item.itemId
                    true
                }

                else -> false
            }
        }

        // 백스택 변경 리스너 추가
        supportFragmentManager.addOnBackStackChangedListener {
            updateBottomNavigation()
        }
    }

    // 액티비티가 다시 포커스될 때 호출되는 메서드
    override fun onResume() {
        super.onResume()
        // 홈 액티비티일 때 바텀 네비게이션을 홈 아이템으로 설정
        binding.bottomNavigation.menu.findItem(R.id.nav_home).isChecked = true
    }

    // 프래그먼트 교체 메서드
    private fun replaceFragment(fragment: Fragment, isRightToLeft: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()

        if (isRightToLeft) {
            transaction.setCustomAnimations(
                R.anim.from_right, // 새 프래그먼트가 오른쪽에서 나타남
                R.anim.to_left,    // 기존 프래그먼트가 왼쪽으로 사라짐
                R.anim.from_left,  // 뒤로 갈 때 새 프래그먼트가 왼쪽에서 나타남
                R.anim.to_right    // 뒤로 갈 때 기존 프래그먼트가 오른쪽으로 사라짐
            )
        } else {
            transaction.setCustomAnimations(
                R.anim.from_left,  // 새 프래그먼트가 왼쪽에서 나타남
                R.anim.to_right,   // 기존 프래그먼트가 오른쪽으로 사라짐
                R.anim.from_right, // 뒤로 갈 때 새 프래그먼트가 오른쪽에서 나타남
                R.anim.to_left     // 뒤로 갈 때 기존 프래그먼트가 왼쪽으로 사라짐
            )
        }

        transaction.replace(R.id.fragment_container_view, fragment)
            .addToBackStack(null) // 백스택에 추가
            .commit()
    }

    // 백스택 변경 시 바텀 네비게이션 업데이트
    private fun updateBottomNavigation() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view)
        when (fragment) {
            null -> {
                // 프래그먼트가 없을 때 (즉, 홈 액티비티로 돌아왔을 때) 홈 선택
                binding.bottomNavigation.menu.findItem(R.id.nav_home).isChecked = true
            }
            is JournalListFragment -> binding.bottomNavigation.menu.findItem(R.id.nav_diary_list).isChecked = true
            is MoodHistoryFragment -> binding.bottomNavigation.menu.findItem(R.id.nav_mood_history).isChecked = true
            is MyPageFragment -> binding.bottomNavigation.menu.findItem(R.id.nav_my_page).isChecked = true
        }
    }
}