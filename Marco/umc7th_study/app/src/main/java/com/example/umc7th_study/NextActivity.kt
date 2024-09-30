package com.example.umc7th_study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc7th_study.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding 초기화
        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 뒤로가기 아이콘 클릭시 NextActivity 종료 (생명주기)
        binding.backIv.setOnClickListener {
            finish()
        }
    }

}