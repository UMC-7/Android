package com.example.androidfloclone

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidfloclone.databinding.FragmentMusicFileBinding

class MusicFileFragment : Fragment() {

    lateinit var binding: FragmentMusicFileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicFileBinding.inflate(inflater, container, false)

        return binding.root
    }
}