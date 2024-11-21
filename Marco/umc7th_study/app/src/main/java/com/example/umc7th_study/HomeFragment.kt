package com.example.umc7th_study

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.umc7th_study.databinding.FragmentHomeBinding
import java.util.Timer
import java.util.TimerTask

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    private var timer : Timer? = null
    private var time: Long = 0
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.homeStartTv.setOnClickListener {
            binding.homeStartTv.visibility = View.GONE
            binding.homePauseTv.visibility = View.VISIBLE
            startTimer()
        }

        binding.homePauseTv.setOnClickListener {
            binding.homeStartTv.visibility = View.VISIBLE
            binding.homePauseTv.visibility = View.GONE
            stopTimer()
        }

        binding.homeClearTv.setOnClickListener {
            clearTimer()
        }

        return binding.root
    }

    private fun startTimer() {
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                time++
                handler.post {
                    binding.homeTimeTv.text = formatTime(time)
                }
            }
        }, 0, 10)
    }

    private fun stopTimer() {
        timer?.cancel()
    }

    private fun clearTimer() {
        time = 0
        binding.homeTimeTv.text = formatTime(time)
    }

    private fun formatTime(time: Long): String {
        val centiseconds = time % 100
        val seconds = (time / 100) % 60
        val minutes = (time / 6000) % 60
        return String.format("%02d:%02d.%02d", minutes, seconds, centiseconds)
    }
}