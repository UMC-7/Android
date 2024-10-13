package com.example.umcstudy

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.umcstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // 현재 위치(index)를 추적하는 변수, 애니메이션 방향 설정에 필요함
    private var currentFragment: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        // ViewBinding 사용
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        // findViewById(R.id.main) -> binding.main 변경
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 버튼 클릭 이벤트
        binding.btnHappy.setOnClickListener {
            moveToSecondActivity("더없이 행복한")
        }
        binding.btnExcited.setOnClickListener {
            moveToSecondActivity("들뜨고 흥분되는")
        }
        binding.btnNeutral.setOnClickListener {
            moveToSecondActivity("평범한")
        }
        binding.btnAnxious.setOnClickListener {
            moveToSecondActivity("생각이 많아지고 불안한")
        }
        binding.btnAngry.setOnClickListener {
            moveToSecondActivity("부글부글 화가 나는")
        }

        // 뒤로가기
//        binding.btnBack.setOnClickListener {
//            finish()
//        }

        // BottomNavigationView 이벤트 추가
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            val targetFragment = when (item.itemId) {
                R.id.nav_home -> 0
                R.id.nav_board -> 1
                R.id.nav_calendar -> 2
                R.id.nav_user -> 3
                else -> 0
            }
            when (item.itemId) {
                R.id.nav_home -> { // 홈 선택 시 FragmentContainerView 숨기기
                    binding.mainContainer.visibility = View.VISIBLE
                    binding.fragmentContainer.visibility = View.GONE
                    currentFragment = targetFragment
                    return@setOnItemSelectedListener true
                }
                R.id.nav_board -> {
                    loadFragment(BoardFragment(), targetFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.nav_calendar -> {
                    loadFragment(CalendarFragment(), targetFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.nav_user -> {
                    loadFragment(UserFragment(), targetFragment)
                    return@setOnItemSelectedListener true
                }
            }
            false
        }

    }

    // SecondActivity로 감정 값 전달
    private fun moveToSecondActivity(emotion: String) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("emotion", emotion)
        startActivity(intent)
    }

    // Fragment 로드
    private fun loadFragment(fragment: Fragment, targetFragment: Int) {
        // Fragment 전환될 때 메인 화면(감정 우표 선택 창) 숨기기
        binding.mainContainer.visibility = View.GONE
        // FragmentContainerView 보이게 하기
        binding.fragmentContainer.visibility = View.VISIBLE

        val transaction = supportFragmentManager.beginTransaction()

        // 현재 프래그먼트 위치에 따른 애니메이션 설정
        // Home -> Board -> Calendar -> User
        if (currentFragment < targetFragment) {
            // 왼쪽에서 오른쪽으로 이동
            transaction.setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )
        } else if (currentFragment > targetFragment) {
            // 오른쪽에서 왼쪽으로 이동
            transaction.setCustomAnimations(
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
        }

        transaction.replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()

        currentFragment = targetFragment // 현재 위치 업데이트
    }

}