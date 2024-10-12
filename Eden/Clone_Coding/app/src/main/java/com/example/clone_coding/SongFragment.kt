package com.example.clone_coding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

        return binding.root


    }

}