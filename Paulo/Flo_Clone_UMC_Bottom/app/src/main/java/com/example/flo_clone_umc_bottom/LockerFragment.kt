package com.example.flo_clone_umc_bottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flo_clone_umc_bottom.databinding.FragmentLockerBinding
import com.example.flo_clone_umc_bottom.databinding.FragmentSavedBinding
import com.google.android.material.tabs.TabLayoutMediator
import java.util.concurrent.locks.Lock

class LockerFragment : Fragment() {

    lateinit var binding: FragmentLockerBinding
    private var information = arrayListOf("저정한 곡","음악파일")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLockerBinding.inflate(inflater, container, false)

        val lockerAdapter = LockerVPAdapter(this)
        binding.lockerContentVp.adapter = lockerAdapter
        TabLayoutMediator(binding.lockerContentTb, binding.lockerContentVp){
            tab, position ->
            tab.text = information[position]
        }.attach()

        return binding.root
    }
}