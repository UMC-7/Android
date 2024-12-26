package com.example.clone_coding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clone_coding.databinding.FragmentBannerBinding


class BannerFragment(val imgRes : Int) : Fragment() {

    lateinit var binding: FragmentBannerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBannerBinding.inflate(inflater, container,false)

        binding.bannerImageIv.setImageResource(imgRes)  //이미지 리소스 id값 넘겨받아서 적용

        return binding.root
    }


}