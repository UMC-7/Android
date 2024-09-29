package com.example.umcstudy

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.umcstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
    }

    // SecondActivity로 감정 값 전달
    private fun moveToSecondActivity(emotion: String) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("emotion", emotion)
        startActivity(intent)
    }

}