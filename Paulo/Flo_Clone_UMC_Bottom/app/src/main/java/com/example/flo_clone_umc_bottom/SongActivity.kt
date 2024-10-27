package com.example.flo_clone_umc_bottom

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.flo_clone_umc_bottom.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {
     lateinit var binding : ActivitySongBinding
     override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          binding = ActivitySongBinding.inflate(layoutInflater)
          setContentView(binding.root)

          binding.songMiniplayerIv.setOnClickListener {
               setPlayerStatus(false)
          }
          binding.songPauseIv.setOnClickListener {
               setPlayerStatus(true)
          }

          binding.songRepeatIv.setOnClickListener {
               setRepeatStatus(false)
          }
          binding.songRepeatingIv.setOnClickListener {
               setRepeatStatus(true)
          }

          binding.songRandomIv.setOnClickListener {
               setRandomStatus(false)
          }
          binding.songRandomingIv.setOnClickListener {
               setRandomStatus(true)
          }

          if(intent.hasExtra("title") && intent.hasExtra("singer")){
               binding.songMusicTitleTv.text = intent.getStringExtra("title")
               binding.songSingerNameTv.text = intent.getStringExtra("singer")
          }

          binding.songDownIb.setOnClickListener{
               val resultIntent = Intent()
               resultIntent.putExtra("ALBUM_TITLE", binding.songMusicTitleTv.text)
               setResult(Activity.RESULT_OK, resultIntent)
               finish()
          }
     }

     fun setPlayerStatus(isPlaying : Boolean){
          if(isPlaying){
               binding.songMiniplayerIv.visibility = View.VISIBLE
               binding.songPauseIv.visibility = View.GONE
          }
          else {
               binding.songMiniplayerIv.visibility = View.GONE
               binding.songPauseIv.visibility = View.VISIBLE
          }
     }

     fun setRepeatStatus(isPlaying : Boolean){
          if(isPlaying){
               binding.songRepeatIv.visibility = View.VISIBLE
               binding.songRepeatingIv.visibility = View.GONE
          }
          else {
               binding.songRepeatIv.visibility = View.GONE
               binding.songRepeatingIv.visibility = View.VISIBLE
          }
     }

     fun setRandomStatus(isPlaying : Boolean) {
          if (isPlaying) {
               binding.songRandomIv.visibility = View.VISIBLE
               binding.songRandomingIv.visibility = View.GONE
          } else {
               binding.songRandomIv.visibility = View.GONE
               binding.songRandomingIv.visibility = View.VISIBLE
          }
     }
}