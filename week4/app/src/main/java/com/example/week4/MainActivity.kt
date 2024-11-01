package com.example.week4

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.week4.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var timer : Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startTimer()

        binding.startButtonTv.setOnClickListener {
            setTimerStatus(isOn = true)
        }
        binding.pauseButtonTv.setOnClickListener {
            setTimerStatus(isOn = false)
        }

        binding.clearButtonTv.setOnClickListener {
            setTimerStatus(isOn=false)
            timer.initTimer()
        }

    }

    private fun setTimerStatus(isOn: Boolean) {
        timer.inOn = isOn

        if (isOn) {
            binding.pauseButtonTv.visibility = View.VISIBLE
            binding.startButtonTv.visibility = View.GONE
        } else {
            binding.pauseButtonTv.visibility = View.GONE
            binding.startButtonTv.visibility = View.VISIBLE
        }
    }

    private fun startTimer(){
        timer = Timer(false)
        timer.start()
    }

    inner class Timer(var inOn: Boolean = false) : Thread() {
        //현재 재생 시간(초)
        private var minute: Int = 0
        private var second: Int = 0
        private var mills: Float = 0f
        private var  isReset = false

        override fun run() {
            super.run()
            try{
                while(true){
                    if(inOn){
                        //10ms 단위로 타이머 업데이트
                        sleep(10)
                        mills += 10

                        if(mills%1000==0f){
                            //1000ms 증가 시 1s 증가
                            second++
                            mills = 0f
                        }
                        if(second%60==0 && second!=0){
                            //60s 증가 시 1m 증가
                            //0 또한 나머지 조건을 만족하기에 0으로 초기화되면서 동시에 조건문을 만족하게 되어 minute이 ms만큼 증가하는 현상 해결
                            minute++
                            second = 0
                            mills = 0f
                        }

                        runOnUiThread{
                            binding.timerTv.text = String.format(Locale.US,"%d:%02d.%02d", minute, second, (mills/10).toInt()) //ms는 두 자리로 표현
                        }
                    }

                    //진행 중 clear 실행 시 10ms가 남는 딜레이 오류를 방지하기 위해 run()에서 초기화
                    if(isReset){
                        minute = 0
                        second = 0
                        mills = 0f

                        runOnUiThread{
                            binding.timerTv.text = "0:00.00"
                        }
                        isReset = false
                    }
                }

            } catch (e: InterruptedException){
                Log.d("timer", "쓰레드가 죽었습니다")
            }
        }

        fun initTimer(){
            isReset = true
        }
    }
}