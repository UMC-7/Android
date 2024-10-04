package com.example.secondmission
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.secondmission.databinding.ActivityMainBinding

private lateinit var binding : ActivityMainBinding  //뷰 바인딩

class MainActivity : AppCompatActivity() {

    // 뒤로가기 콜백 인스턴스 생성
    private val backPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (supportFragmentManager.backStackEntryCount > 0) {
                supportFragmentManager.popBackStack()   //이전 fragment로 리턴
            } else {
                finish()  // 백스택이 비어 있을 때 액티비티 종료
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)    //activity_main.xml 세팅

        if (savedInstanceState == null) {
            //초기화면 로딩 ; Home
            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainerView.id, HomeFragment())
                .commit()
        }

        // BottomNavigationView 아이템 선택 리스너 설정
        binding.bottomNavi.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navi_home -> {
                    switchFragment(HomeFragment(), R.id.navi_home)
                    true
                }
                R.id.navi_write -> {
                    switchFragment(WriteFragment(), R.id.navi_write)
                    true
                }
                R.id.navi_me -> {
                    switchFragment(MeFragment(), R.id.navi_me)
                    true
                }
                else -> false
            }
        }

        // 뒤로가기 콜백을 등록
        onBackPressedDispatcher.addCallback(this, backPressedCallback)

        //백스택 pop 시 비동기 문제 해결
        supportFragmentManager.addOnBackStackChangedListener {
            // 백스택에서 마지막으로 남은 Fragment에 맞춰 BottomNavigationView 상태 동기화
            val currentFragment = supportFragmentManager.fragments.lastOrNull()
            when (currentFragment) {
                is HomeFragment -> binding.bottomNavi.menu.findItem(R.id.navi_home).isChecked = true
                is WriteFragment -> binding.bottomNavi.menu.findItem(R.id.navi_write).isChecked = true
                is MeFragment -> binding.bottomNavi.menu.findItem(R.id.navi_me).isChecked = true
            }
        }

    }

    private fun switchFragment(fragment: Fragment, itemId: Int) {
        supportFragmentManager.commit {
            setCustomAnimations(
                R.anim.slide_in,    //enter
                R.anim.fade_out,    //exit
                R.anim.fade_in,     //popEnter
                R.anim.slide_out    //popExit
            )
            replace(R.id.fragmentContainerView, fragment)
            addToBackStack(null)    // 이전 Fragment로 돌아갈 수 있도록 백스택에 추가
        }

        // BottomNavigationView의 상태를 업데이트
        binding.bottomNavi.menu.findItem(itemId).isChecked = true
    }


}