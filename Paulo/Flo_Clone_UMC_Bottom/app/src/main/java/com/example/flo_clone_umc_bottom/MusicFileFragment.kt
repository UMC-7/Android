package com.example.flo_clone_umc_bottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flo_clone_umc_bottom.databinding.FragmentMusicfileBinding
import com.example.flo_clone_umc_bottom.databinding.FragmentVideoBinding

class MusicFileFragment : Fragment() {

    lateinit var binding: FragmentMusicfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicfileBinding.inflate(inflater, container, false)
        return binding.root
    }
}