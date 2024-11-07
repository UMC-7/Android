package com.example.flo_clone_umc_bottom

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.flo_clone_umc_bottom.databinding.ActivitySongBinding
import com.google.gson.Gson

class SongActivity : AppCompatActivity() {
     lateinit var binding : ActivitySongBinding
     lateinit var song : Song
     lateinit var timer: Timer
     private var mediaPlayer: MediaPlayer? = null
     private var gson : Gson = Gson()
     private var repeat = false //5주차 repeat 변수

     override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          binding = ActivitySongBinding.inflate(layoutInflater)
          setContentView(binding.root)

          initSong()
          setPlayer(song)

          var repeat = false

          binding.songMiniplayerIv.setOnClickListener {
               setPlayerStatus(false)
          }
          binding.songPauseIv.setOnClickListener {
               setPlayerStatus(true)
          }

          binding.songRepeatIv.setOnClickListener {
               setRepeatStatus(true)
          }
          binding.songRepeatingIv.setOnClickListener {
               setRepeatStatus(false)
          }
          //5주차 setRepeatStatus 함수에 맞춰 true, false 변경

          binding.songRandomIv.setOnClickListener {
               setRandomStatus(false)
          }
          binding.songRandomingIv.setOnClickListener {
               setRandomStatus(true)
          }

          binding.songDownIb.setOnClickListener{
               val resultIntent = Intent()
               resultIntent.putExtra("ALBUM_TITLE", binding.songMusicTitleTv.text)
               setResult(Activity.RESULT_OK, resultIntent)
               finish()
          }
     }

     private fun initSong(){
          if(intent.hasExtra("title") && intent.hasExtra("singer")){
               song = Song(
                    intent.getStringExtra("title")!!,
                    intent.getStringExtra("singer")!!,
                    intent.getIntExtra("second",0),
                    intent.getIntExtra("playTime",0),
                    intent.getBooleanExtra("isPlaying",false),
                    intent.getStringExtra("music")!!
               )
          }
          startTimer()
     }

     private fun setPlayer(song : Song){
          binding.songMusicTitleTv.text = intent.getStringExtra("title")
          binding.songSingerNameTv.text = intent.getStringExtra("singer")
          binding.songStartTimeTv.text = String.format("%02d:%02d",song.second /60, song.second % 60)
          binding.songEndTimeTv.text = String.format("%02d:%02d",song.playTime /60, song.playTime % 60)
          binding.songProgressSb.progress = (song.second * 1000 / song.playTime)
          val music = resources.getIdentifier(song.music, "raw", this.packageName)
          mediaPlayer = MediaPlayer.create(this,music)

          setPlayerStatus(song.isPlaying)
     }

     fun setPlayerStatus(isPlaying : Boolean){
          song.isPlaying = isPlaying
          timer.isPlaying = isPlaying
          if(isPlaying){
               binding.songMiniplayerIv.visibility = View.VISIBLE
               binding.songPauseIv.visibility = View.GONE
               mediaPlayer?.start()
          }
          else {
               binding.songMiniplayerIv.visibility = View.GONE
               binding.songPauseIv.visibility = View.VISIBLE
               if(mediaPlayer?.isPlaying == true){
                    mediaPlayer?.pause()
               }
          }
     }

     private fun startTimer() {
          if (::timer.isInitialized) {
               timer.interrupt()
          }
          timer = Timer(song.playTime, song.isPlaying)
          timer.start()
     }
     //5주차 기존 타이머 스레드 종료 및 시작

     inner class Timer(private val playTime: Int, var isPlaying: Boolean = true): Thread() {
          private var second: Int = 0
          private var mills: Float = 0f

          override fun run() {
               super.run()
               try {
                    while (true) {
                         if (second >= playTime) {
                              if (repeat) {
                                   //5주차 repeat이 활성화된 경우, 노래를 다시 시작
                                   second = 0
                                   mills = 0f
                                   mediaPlayer?.seekTo(0)
                                   mediaPlayer?.start()
                              } else {
                                   break
                              }
                         }

                         if (isPlaying) {
                              sleep(50)
                              mills += 50

                              runOnUiThread {
                                   binding.songProgressSb.progress = ((mills / playTime) * 100).toInt()
                              }
                              if (mills % 1000 == 0f) {
                                   runOnUiThread {
                                        binding.songStartTimeTv.text = String.format("%02d:%02d", second / 60, second % 60)
                                   }
                                   second++
                              }
                         }
                    }
               } catch (e: InterruptedException) {
                    Log.d("Song", "쓰레드가 죽었습니다. ${e.message}")
               }
          }
     }

     override fun onPause() {
          setPlayerStatus(false)
          super.onPause()
          song.second = ((binding.songProgressSb.progress * song.playTime)/100)/1000
          val sharedPreferences = getSharedPreferences("song", MODE_PRIVATE)
          val editor = sharedPreferences.edit()
          editor.putString("title", song.title)
          val songJson = gson.toJson(song)
          editor.putString("songData", songJson)

          editor.apply()
     }

     override fun onDestroy() {
          super.onDestroy()
          timer.interrupt()
          mediaPlayer?.release()
          mediaPlayer = null
     }

     fun setRepeatStatus(isRepeating: Boolean) {
          repeat = isRepeating // repeat 변수 업데이트
          if (repeat) {
               binding.songRepeatIv.visibility = View.GONE
               binding.songRepeatingIv.visibility = View.VISIBLE
          } else {
               binding.songRepeatIv.visibility = View.VISIBLE
               binding.songRepeatingIv.visibility = View.GONE
          }
     }
     //5주차 repeat에 맞춰 변경

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