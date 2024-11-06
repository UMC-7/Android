package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentTimerBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimerFragment:Fragment(R.layout.fragment_timer) {
    private var _binding: FragmentTimerBinding? = null
    private val binding get() = _binding!!

    private var job: Job? = null
    private var timeInSeconds = 0
    private var isRunning = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTimerBinding.bind(view)
        binding.timerStartBu.setOnClickListener {
            if(!isRunning){
                startStopwatch()
            }
        }

        binding.timerPauseBu.setOnClickListener {
            pauseStopwatch()
        }

        binding.timerResetBu.setOnClickListener {
            resetStopwatch()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun startStopwatch() {
        isRunning = true
        job = CoroutineScope(Dispatchers.Main).launch {
            while (isRunning) {
                delay(1000L)
                timeInSeconds++
                updateTimerText()
            }
        }
    }

    private fun pauseStopwatch() {
        isRunning = false
        job?.cancel()
    }

    private fun resetStopwatch() {
        pauseStopwatch()
        timeInSeconds = 0
        updateTimerText()
    }

    private fun updateTimerText() {
        val hours = timeInSeconds / 3600
        val minutes = (timeInSeconds % 3600) / 60
        val seconds = timeInSeconds % 60
        binding.timerTimerTv.text = String.format("%02d:%02d:%02d",hours , minutes, seconds) // "MM:SS" 형식으로 표시
    }
}