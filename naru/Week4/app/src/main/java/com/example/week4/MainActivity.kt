package com.example.week4

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.week4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isRunning = false
    private var time = 0
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handler = Handler(Looper.getMainLooper())

        // 버튼 클릭 리스너 설정
        binding.btnStart.setOnClickListener {
            if (isRunning) {
                pause()
            } else {
                start()
            }
        }

        binding.btnClear.setOnClickListener {
            clear()
        }
    }

    private fun start() {
        binding.btnStart.text = "중지"
        binding.btnStart.setBackgroundColor(Color.RED)
        isRunning = true

        runnable = object : Runnable {
            override fun run() {
                if (isRunning) {
                    time++
                    val millisecond = time % 100
                    val second = (time / 100) % 60
                    val minute = time / 6000

                    binding.millisecondTv.text = if (millisecond < 10) ".0${millisecond}" else ".${millisecond}"
                    binding.secondTv.text = if (second < 10) ":0${second}" else ":${second}"
                    binding.minuteTv.text = if (minute < 10) "0${minute}" else "${minute}"

                    handler.postDelayed(this, 10)
                }
            }
        }
        handler.post(runnable)
    }




    private fun pause() {
        binding.btnStart.text = "계속"
        binding.btnStart.setBackgroundColor(Color.parseColor("#6464ff"))
        isRunning = false
        handler.removeCallbacks(runnable)
    }

    private fun clear() {
        handler.removeCallbacks(runnable)

        binding.btnStart.text = "시작"
        binding.btnStart.setBackgroundColor(Color.parseColor("#6464ff"))
        isRunning = false

        time = 0
        binding.millisecondTv.text = ".00"
        binding.secondTv.text = ":00"
        binding.minuteTv.text = "00"
    }
}

