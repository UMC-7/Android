package com.example.androidfloclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidfloclone.databinding.FragmentPanelBinding

class PanelFragment(val imgRes : Int) : Fragment() {
    lateinit var binding : FragmentPanelBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPanelBinding.inflate(inflater, container, false)

        binding.homePanelBackgroundIv.setImageResource(imgRes)
        return binding.root
    }
}