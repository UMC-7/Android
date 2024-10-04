package com.example.secondmission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HomeFragment : Fragment() {

    override fun onCreateView(
        //매개변수들
        inflater: LayoutInflater,   //뷰 생성 객체
        container: ViewGroup?,      //생성할 뷰의 부모 뷰
        savedInstanceState: Bundle? //이전 Fragment에서 전달된 데이터(By bundle)
    ): View? {
        // 뷰 객체로 변환
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}