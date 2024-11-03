package com.example.week4

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.week4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isRunning = false // 타이머 실행 여부를 나타내는 변수
    private var time = 0 // 타이머 시간을 초 단위로 저장하는 변수
    // 핸들러와 Runnable 객체 초기화
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding을 통해 레이아웃 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 메인 스레드에서 작업을 수행하기 위한 핸들러 초기화
        handler = Handler(Looper.getMainLooper())

        // 시작 버튼 클릭 리스너 설정
        binding.btnStart.setOnClickListener {
            if (isRunning) {
                pause() // 타이머가 실행 중이면 중지
            } else {
                start() // 타이머가 정지 상태이면 시작
            }
        }

        // 클리어 버튼 클릭 리스너 설정
        binding.btnClear.setOnClickListener {
            clear() // 타이머 초기화
        }
    }

    private fun start() {
        // 버튼 텍스트 및 배경 색상 변경
        binding.btnStart.text = "중지"
        binding.btnStart.setBackgroundColor(Color.RED)
        isRunning = true // 타이머 실행 상태로 변경

        // Runnable 객체 정의
        runnable = object : Runnable {
            override fun run() {
                if (isRunning) { // 타이머가 실행 중일 경우
                    time++ // 시간 증가
                    // 시간 계산 (밀리초, 초, 분)
                    val millisecond = time % 100
                    val second = (time / 100) % 60
                    val minute = time / 6000

                    // UI에 시간 업데이트
                    binding.millisecondTv.text = if (millisecond < 10) ".0${millisecond}" else ".${millisecond}"
                    binding.secondTv.text = if (second < 10) ":0${second}" else ":${second}"
                    binding.minuteTv.text = if (minute < 10) "0${minute}" else "${minute}"

                    // 10ms 후에 다시 실행
                    handler.postDelayed(this, 10)
                }
            }
        }
        handler.post(runnable) // Runnable 실행
    }

    private fun pause() {
        // 버튼 텍스트 및 배경 색상 변경
        binding.btnStart.text = "계속"
        binding.btnStart.setBackgroundColor(Color.parseColor("#6464ff"))
        isRunning = false // 타이머 일시 정지 상태로 변경
        handler.removeCallbacks(runnable) // Runnable 제거
    }

    private fun clear() {
        handler.removeCallbacks(runnable) // 실행 중인 Runnable 제거

        // 버튼 텍스트 및 색상 초기화
        binding.btnStart.text = "시작"
        binding.btnStart.setBackgroundColor(Color.parseColor("#6464ff"))
        isRunning = false // 타이머 정지 상태로 변경

        // 타이머 시간 초기화
        time = 0
        binding.millisecondTv.text = ".00"
        binding.secondTv.text = ":00"
        binding.minuteTv.text = "00"
    }
}

