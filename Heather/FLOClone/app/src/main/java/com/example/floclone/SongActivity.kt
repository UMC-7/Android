package com.example.floclone

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.floclone.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {

    lateinit var binding: ActivitySongBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 내리기 버튼 클릭 시 현재 액티비티 종료
        binding.songDownIb.setOnClickListener {
            returnSongTitle()  // 노래 제목 반환
            finish()
        }

        binding.songMiniplayerIv.setOnClickListener {
            setPlayerStatus(false)
        }
        binding.songPauseIv.setOnClickListener {
            setPlayerStatus(true)
        }

        // MainActivity에서 전달받은 노래 제목과 가수 이름으로 TextView 값 변경
        if (intent.hasExtra("title") && intent.hasExtra("singer")) {
            binding.songMusicTitleTv.text = intent.getStringExtra("title")
            binding.songSingerNameTv.text = intent.getStringExtra("singer")
        }
    }

    // 재생 버튼의 상태를 바꿔주는 메서드
    fun setPlayerStatus(isPlaying : Boolean) {
        if (isPlaying) {
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
        } else {
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
        }
    }

    // 노래 제목을 MainActivity로 반환하는 메서드
    private fun returnSongTitle() {
        val returnIntent = Intent()
        val songTitle = binding.songMusicTitleTv.text.toString()
        returnIntent.putExtra("songTitle", songTitle)
        setResult(RESULT_OK, returnIntent)
    }

    override fun onBackPressed() {
        returnSongTitle()  // 뒤로가기 눌렀을 때도 데이터 반환
        super.onBackPressed()
    }

}