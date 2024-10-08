package com.example.secondmission

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)    //앱 실행 시 화면

        // 일정 시간 지연 후 실행
        Handler(Looper.getMainLooper()).postDelayed({

            // 일정 시간이 지나면 MainActivity로 이동
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // 이전 키를 눌렀을 때 스플래쉬 화면으로 이동 방지 - 사용안함 처리
            finish()

        }, 2000) // 시간 2초 이후 실행
    }
}