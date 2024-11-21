package com.example.umc7th_study

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.umc7th_study.databinding.ActivityContentBinding

class ContentActivity : AppCompatActivity() {
    lateinit var binding: ActivityContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // ViewBinding 초기화
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val memoContent = intent.getStringExtra("memoContent")
        binding.memoContentTv.text = memoContent
    }
}