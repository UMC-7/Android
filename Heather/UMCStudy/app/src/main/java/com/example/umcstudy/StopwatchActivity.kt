package com.example.umcstudy

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.umcstudy.databinding.ActivityStopwatchBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class StopwatchActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStopwatchBinding
    private var currentTimeMillis = 0L
    private var isRunning = false
    private var coroutineScope = CoroutineScope(Dispatchers.Main + Job())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityStopwatchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupUI()
    }

    private fun setupUI() {
        binding.startPauseBtn.setOnClickListener {
            if (isRunning) {
                pause()
            } else {
                start()
            }
            updateStartPauseButton()
        }

        binding.clearBtn.setOnClickListener {
            clear()
        }
    }

    // 스톱워치 시작 함수
    private fun start() {
        if (isRunning) return

        isRunning = true
        coroutineScope.launch {
            val startTime = System.currentTimeMillis()
            while (isActive) { // 코루틴이 활성화되어 있는 동안 반복
                currentTimeMillis = System.currentTimeMillis() - startTime
                binding.stopwatchTv.text = formatTime(currentTimeMillis)
                delay(10) // 10ms 마다 업데이트(성능 최적화)
            }
        }
    }

    // 스톱워치 일시 정지 함수
    private fun pause() {
        isRunning = false
        coroutineScope.coroutineContext.cancelChildren() // 실행 중인 코루틴 취소
        updateStartPauseButton()
    }

    // 스톱워치 초기화 함수
    private fun clear() {
        coroutineScope.coroutineContext.cancelChildren()
        currentTimeMillis = 0L // 시간 초기화
        binding.stopwatchTv.text = "00:00,00"

        if (isRunning) {
            // 실행 중이면 0부터 다시 시작
            start()
        } else {
            // 정지 상태면 초기화만 수행
            isRunning = false
            updateStartPauseButton()
        }
    }

    private fun updateStartPauseButton() {
        binding.startPauseBtn.text = if (isRunning) "Pause" else "Start"
    }

    private fun formatTime(timeMillis: Long): String {
        val minutes = (timeMillis / (1000 * 60)).toInt()
        val seconds = (timeMillis % (1000 * 60) / 1000).toInt()
        val centiseconds = (timeMillis % 1000 / 10).toInt()

        return String.format("%02d:%02d,%02d", minutes, seconds, centiseconds)
    }

    // 액티비티가 종료될 떄 코루틴 정리
    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel()
    }
}