package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentHomeBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

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

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
