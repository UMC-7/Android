package com.example.umc7th_study

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.umc7th_study.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // ViewBinding 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 각 이미지 클릭시 NextActivity로 전환 (Intent 이용)
        binding.emo1Iv.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            intent.putExtra("id", 1)
            startActivity(intent)
        }

        binding.emo2Iv.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            intent.putExtra("id", 2)
            startActivity(intent)
        }

        binding.emo3Iv.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            intent.putExtra("id", 3)
            startActivity(intent)
        }

        binding.emo4Iv.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            intent.putExtra("id", 4)
            startActivity(intent)
        }

        binding.emo5Iv.setOnClickListener {
            val intent = Intent(this, MemoActivity::class.java)
            startActivity(intent)
        }
    }

}