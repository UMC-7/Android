package com.example.moodjournal

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_splash)  // activity_splash 레이아웃을 설정

        Handler(Looper.getMainLooper()).postDelayed({  // 3초 후에 실행될 작업 설정

            val intent = Intent (this,MainActivity::class.java)
            startActivity(intent)

            finish()
        }, 3000)
    }
}