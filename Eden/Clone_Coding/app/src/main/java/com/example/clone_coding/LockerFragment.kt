package com.example.clone_coding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clone_coding.databinding.FragmentLockerBinding
import com.google.android.material.tabs.TabLayoutMediator


class LockerFragment : Fragment() {

    private lateinit var binding: FragmentLockerBinding
    private var information = arrayListOf("저장한 곡", "음악파일")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLockerBinding.inflate(inflater, container, false)

        val lockerAdapter = LockerVPAdapter(this)
        binding.lockerContentVp.adapter = lockerAdapter

        TabLayoutMediator(binding.lockerContentTb, binding.lockerContentVp){
            //탭의 제목 설정
                tab, position -> tab.text = information[position]
        }.attach()

        return binding.root

    }


}