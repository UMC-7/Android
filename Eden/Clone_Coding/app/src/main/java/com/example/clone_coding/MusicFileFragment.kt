package com.example.clone_coding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clone_coding.databinding.FragmentMusicFileBinding
import com.example.clone_coding.databinding.FragmentSongBinding

class MusicFileFragment : Fragment() {
    private lateinit var binding: FragmentMusicFileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicFileBinding.inflate(inflater, container, false)

        return binding.root
    }

}