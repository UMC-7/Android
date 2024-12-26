package com.example.androidfloclone

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.androidfloclone.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetFragment : BottomSheetDialogFragment() {
    lateinit var binding: FragmentBottomSheetBinding
    lateinit var songDB: SongDatabase
    private lateinit var savedSongRVAdapter: SavedSongRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetBinding.inflate(inflater, container,false)
        songDB = SongDatabase.getInstance(requireContext())!!
        savedSongRVAdapter = SavedSongRVAdapter()

        // 바텀 시트에서 삭제 버튼 클릭 시 처리
        binding.bottomSheetDeleteBtn.setOnClickListener {
            songDB.songDao().unlikeAllSongs()

            savedSongRVAdapter.removeAllSongs()

            dismiss() // 바텀 시트 닫기
            Toast.makeText(requireContext(), "삭제", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

}