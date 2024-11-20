package com.example.umc7th_flo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.umc7th_flo.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {
    //소괄호 : 클래스를 다른 클래스로 상속을 진행할 때는 소괄호를 넣어줘야 한다.

    //전역 변수
    lateinit var binding : ActivitySongBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // MainActivity에서 전달받은 값 받아서 반영
        if(intent.hasExtra("title") && intent.hasExtra("singer")){
            binding.songMusicTitleTv.text = intent.getStringExtra("title")
            binding.songSingerNameTv.text = intent.getStringExtra("singer")
        }

        // MainActivity로 앨범 텍스트 전달
        binding.songDownIb.setOnClickListener {
            val intent2 = Intent(this, MainActivity::class.java)
            intent2.putExtra("title", intent.getStringExtra("title"))
            setResult(RESULT_OK, intent2)
            finish()
        }

        binding.songMiniplayerIv.setOnClickListener {
            setPlayerStatus(false)
        }
        binding.songPauseIv.setOnClickListener {
            setPlayerStatus(true)
        }

        // 반복재생 사진 변경
        binding.songRepeatIv.setOnClickListener {
            binding.songRepeatIv.visibility = View.GONE
            binding.songRepeatOnIv.visibility = View.VISIBLE
        }
        binding.songRepeatOnIv.setOnClickListener {
            binding.songRepeatIv.visibility = View.VISIBLE
            binding.songRepeatOnIv.visibility = View.GONE
        }

        // 랜덤재생 사진 변경
        binding.songRandomIv.setOnClickListener {
            binding.songRandomIv.visibility = View.GONE
            binding.songRandomOnIv.visibility = View.VISIBLE
        }
        binding.songRandomOnIv.setOnClickListener {
            binding.songRandomIv.visibility = View.VISIBLE
            binding.songRandomOnIv.visibility = View.GONE
        }


    }

    fun setPlayerStatus (isPlaying : Boolean){
        if(isPlaying){
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
        } else {
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
        }
    }
}