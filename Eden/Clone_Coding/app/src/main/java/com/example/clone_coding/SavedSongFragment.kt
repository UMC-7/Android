package com.example.clone_coding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clone_coding.databinding.FragmentSavedSongBinding

class SavedSongFragment : Fragment() {
    private lateinit var binding : FragmentSavedSongBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSavedSongBinding.inflate(inflater, container, false)
        return binding.root
    }
}