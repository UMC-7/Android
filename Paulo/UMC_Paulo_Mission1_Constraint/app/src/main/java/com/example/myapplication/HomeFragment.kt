package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // View Binding 설정
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // 각 ImageView에 대한 클릭 리스너 설정
        binding.imageViewR.setOnClickListener {
            openActivity2()
        }
        binding.imageViewB.setOnClickListener {
            openActivity2()
        }
        binding.imageViewG.setOnClickListener {
            openActivity2()
        }
        binding.imageViewP.setOnClickListener {
            openActivity2()
        }
        binding.imageViewY.setOnClickListener {
            openActivity2()
        }

        return binding.root // Inflate된 뷰 반환
    }

    private fun openActivity2() {
        val intent = Intent(requireActivity(), MainActivity2::class.java)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
