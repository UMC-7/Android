package com.example.week6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week6.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var subjects =ArrayList<Subject>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentHomeBinding.inflate(inflater, container, false)

        subjects.apply {
            add(Subject("객체지향프로그래밍 01분반", "#ff2717"))
            add(Subject("데이타베이스설계 01분반", "#009606"))
            add(Subject("오토마타와형식언어 01분반", "#06a3b7"))
            add(Subject("컴퓨터구조 01분반", "#468dbb"))
            add(Subject("프로그래밍언어론 02분반", "#d97900"))
            add(Subject("트렌드를읽는데이터경영 02분반", "#fd5d10"))
            add(Subject("임시 01분반"))
            add(Subject("임시 02분반"))
            add(Subject("임시 03분반"))
            add(Subject("임시 04분반"))
        }

        var subjectRVAdapter = SubjectRVAdapter(subjects)
        binding.homeMySubjectsRv.adapter = subjectRVAdapter
        binding.homeMySubjectsRv.layoutManager = GridLayoutManager(context, 2)

        return binding.root
    }

}