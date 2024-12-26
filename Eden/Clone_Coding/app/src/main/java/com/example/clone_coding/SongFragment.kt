package com.example.clone_coding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.clone_coding.databinding.FragmentSongBinding

class SongFragment : Fragment() {
    lateinit var binding: FragmentSongBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongBinding.inflate(inflater, container, false)

        binding.songLalacLayout.setOnClickListener{
            Toast.makeText(activity, "LILAC", Toast.LENGTH_SHORT).show()
        }

        //MIX 버튼 상태 변경
        binding.songMixoffTg.setOnClickListener {
            changeMIXStatus(true)
        }
        binding.songMixonTg.setOnClickListener {
            changeMIXStatus(false)
        }

        return binding.root


    }

    private fun changeMIXStatus(isMIX : Boolean){
        if(isMIX){
            binding.songMixoffTg.visibility = View.GONE
            binding.songMixonTg.visibility = View.VISIBLE
        }
        else{
            binding.songMixonTg.visibility = View.GONE
            binding.songMixoffTg.visibility = View.VISIBLE
        }
    }

}