package com.example.clone_coding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clone_coding.databinding.FragmentHomePanel1Binding

class HomePanel1Fragment : Fragment() {
    private lateinit var binding : FragmentHomePanel1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePanel1Binding.inflate(inflater,container,false)
        return binding.root
    }
}