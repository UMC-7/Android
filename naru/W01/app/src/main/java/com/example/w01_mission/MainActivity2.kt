package com.example.w01_mission

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.w01_mission.databinding.ActivityMain2Binding  // 뷰 바인딩 임포트

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding  // 뷰 바인딩 객체 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // ActivityMain2Binding을 통해 레이아웃을 인플레이트하고 바인딩 객체 초기화
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 시스템 바의 여백을 설정하여 뷰가 올바르게 표시되도록 처리
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->  // binding.main 사용
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 뒤로가기 버튼
        binding.backButton.setOnClickListener {  // binding.backButton 사용
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
