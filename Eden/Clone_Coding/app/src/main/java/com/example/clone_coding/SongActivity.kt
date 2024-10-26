package com.example.clone_coding

import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.clone_coding.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySongBinding
    private var isRepeatColorChanged = false
    private var isRandomColorChanged = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.songDownIb.setOnClickListener {
            val title = binding.songMusicTitleTv.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("title", title)
            setResult(Activity.RESULT_OK, intent)

            finish()
        }

        //반복재생 설정
        binding.songRepeatIv.setOnClickListener {
            if (isRepeatColorChanged) {
                binding.songRepeatIv.setColorFilter(ContextCompat.getColor(this, R.color.flo), PorterDuff.Mode.SRC_ATOP)
            } else {
                binding.songRepeatIv.setColorFilter(ContextCompat.getColor(this, R.color.colorPrimaryGrey), PorterDuff.Mode.SRC_ATOP)
            }
            isRepeatColorChanged = !isRepeatColorChanged // 상태 반전
        }

        //랜덤재생 설정
        binding.songRandomIv.setOnClickListener {
            if (isRandomColorChanged) {
//                binding.songRandomIv.setColorFilter(ContextCompat.getColor(this, R.color.flo), PorterDuff.Mode.SRC_ATOP)  //ColorFilter 방식
                binding.songRandomIv.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this@SongActivity, R.color.flo)) //Tint 방식
            } else {
//                binding.songRandomIv.setColorFilter(ContextCompat.getColor(this, R.color.colorPrimaryGrey), PorterDuff.Mode.SRC_ATOP)
                binding.songRandomIv.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this@SongActivity, R.color.colorPrimaryGrey))

            }
            isRandomColorChanged = !isRandomColorChanged // 상태 반전
        }



        binding.songMiniplayerIv.setOnClickListener {
            setPlayerStatus(true)
        }

        binding.songPauseIv.setOnClickListener {
            setPlayerStatus(false)
        }

        //미니플레이어에 있는 데이터 반영
        if(intent.hasExtra("title") && intent.hasExtra("singer")){
            binding.songMusicTitleTv.text = intent.getStringExtra("title")
            binding.songSingerNameTv.text = intent.getStringExtra("singer")

        }


    }

    private fun setPlayerStatus (isPlaying : Boolean){
        if(isPlaying){
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
        } else {
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
        }

    }
}