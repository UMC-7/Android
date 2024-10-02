package com.example.umcstudy

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.umcstudy.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding 사용
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        // findViewById(R.id.main) -> binding.main 변경
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 뒤로가기
        binding.btnBack.setOnClickListener {
            finish()
        }

        // MainActivity에서 받아온 emotion값
        val emotion = intent.getStringExtra("emotion")
        if (emotion != null) {
            // ViewBinding에서는 xml ID를 Camel case로 참조할 수 있음
            binding.textEmotion.text = "오늘은\n$emotion\n하루를 보냈군요!"
        }

    }
}