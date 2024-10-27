package com.example.androidfloclone

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.androidfloclone.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {

    lateinit var binding: ActivitySongBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 버튼 클릭 시 제목 전달하고 액티비티 종료
        binding.songDownIb.setOnClickListener {
            // 제목을 텍스트뷰에서 가져옴
            val songTitle = binding.songMusicTitleTv.text.toString()

            // 결과를 담을 intent 생성
            val intent = Intent().apply {
                putExtra("SONG_TITLE", songTitle) // 제목을 intent에 추가
            }
            // 결과를 RESULT_OK와 설정하고 액티비티 종료
            setResult(RESULT_OK, intent)
            finish()
        }

        // 플레이 버튼 이미지 변경
        binding.songMiniplayerIv.setOnClickListener {
            setPlayerStatus(false)
        }
        binding.songPauseIv.setOnClickListener {
            setPlayerStatus(true)
        }

        // 랜덤 재생 버튼 이미지 변경
        binding.songRandomIv.setOnClickListener {
            binding.songRandomIv.visibility = View.GONE
            binding.songRandomActiveIv.visibility = View.VISIBLE
        }
        binding.songRandomActiveIv.setOnClickListener {
            binding.songRandomIv.visibility = View.VISIBLE
            binding.songRandomActiveIv.visibility = View.GONE
        }

        // 반복 재생 이미지 변경
        binding.songRepeatIv.setOnClickListener {
            binding.songRepeatIv.visibility = View.GONE
            binding.songRepeatActiveIv.visibility = View.VISIBLE
        }
        binding.songRepeatActiveIv.setOnClickListener {
            binding.songRepeatIv.visibility = View.VISIBLE
            binding.songRepeatActiveIv.visibility = View.GONE
        }

        // intent에서 제목과 가수 정보
        if(intent.hasExtra("title") && intent.hasExtra("singer")) {
            binding.songMusicTitleTv.text = intent.getStringExtra("title")
            binding.songSingerNameTv.text = intent.getStringExtra("singer")
        }


    }

    // 플레이 상태를 설정하는 함수
    fun setPlayerStatus(isPlaying : Boolean) {
        if (isPlaying) {
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
        }
        else {
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
        }
    }
}