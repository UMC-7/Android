package com.example.moodjournal

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.moodjournal.databinding.ActivityMoodQuestionsBinding

class MoodQuestionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoodQuestionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 뷰 바인딩 초기화
        binding = ActivityMoodQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 시스템 바에 맞게 패딩 조정
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 뒤로가기 버튼 클릭 시 MainActivity로 돌아가기
        binding.backButton.setOnClickListener {
            finish() // 현재 액티비티 종료
        }
    }
}
