package com.example.floclone

import android.content.Intent
import android.graphics.PorterDuff
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.floclone.databinding.ActivitySongBinding
import com.google.gson.Gson
import java.util.Timer
import java.util.concurrent.TimeUnit

class SongActivity : AppCompatActivity() {

    lateinit var binding: ActivitySongBinding
    lateinit var song: Song
    lateinit var timer: Timer
    private var mediaPlayer: MediaPlayer? = null
    private var gson: Gson = Gson()

    private var isRepeatActive = false
    private var isRandomActive = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSong()
        setPlayer(song)

        binding.songDownIb.setOnClickListener {
            finish()
        }

        binding.songMiniplayerIv.setOnClickListener {
            setPlayerStatus(true)
        }

        binding.songPauseIv.setOnClickListener {
            setPlayerStatus(false)
        }

        // 반복 재생 버튼 클릭 리스너 추가
        binding.songRepeatIv.setOnClickListener {
            isRepeatActive = !isRepeatActive
            if (isRepeatActive) {
                binding.songRepeatIv.setColorFilter(
                    ContextCompat.getColor(this, R.color.select_color),
                    PorterDuff.Mode.SRC_IN
                )
            } else {
                binding.songRepeatIv.clearColorFilter()
            }
        }

        // 랜덤 재생 버튼 클릭 리스너 추가
        binding.songRandomIv.setOnClickListener {
            isRandomActive = !isRandomActive
            if (isRandomActive) {
                binding.songRandomIv.setColorFilter(
                    ContextCompat.getColor(this, R.color.select_color),
                    PorterDuff.Mode.SRC_IN
                )
            } else {
                binding.songRandomIv.clearColorFilter()
            }
        }
    }

    private fun initSong() {
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

        // MediaPlayer 초기화 및 저장된 위치로 이동
        val music = resources.getIdentifier(song.music, "raw", this.packageName)
        mediaPlayer = MediaPlayer.create(this, music)
        mediaPlayer?.seekTo(song.second * 1000)  // 밀리초 단위로 변환해서 이동

        startTimer(song.second * 1000L)  // 저장된 second 값을 밀리초로 변환하여 전달
    }

    private fun setPlayer(song: Song) {
        binding.songMusicTitleTv.text = intent.getStringExtra("title")!!
        binding.songSingerNameTv.text = intent.getStringExtra("singer")!!
        binding.songStartTimeTv.text = String.format("%02d:%02d",song.second / 60, song.second % 60)
        binding.songEndTimeTv.text = String.format("%02d:%02d",song.playTime / 60, song.playTime % 60)

        // SeekBar 설정
        binding.songProgressSb.max = song.playTime * 1000
        binding.songProgressSb.progress = song.second * 1000

//        val music = resources.getIdentifier(song.music, "raw", this.packageName)
//        mediaPlayer = MediaPlayer.create(this, music)

        // SeekBar 클릭 이벤트 리스너 설정
        binding.songProgressSb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer?.seekTo(progress)
                    timer.mills = progress.toLong()
                    timer.second = progress / 1000
                }
                binding.songStartTimeTv.text = String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(progress.toLong()),
                    TimeUnit.MILLISECONDS.toSeconds(progress.toLong()) % 60)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        setPlayerStatus(song.isPlaying)
    }

    private fun setPlayerStatus(isPlaying: Boolean) {
        song.isPlaying = isPlaying
        timer.isPlaying = isPlaying

        if (isPlaying) {
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
            // mediaPlayer?.start()

            if (mediaPlayer?.isPlaying == false) {
                mediaPlayer?.seekTo(binding.songProgressSb.progress)  // 현재 위치로 이동
                mediaPlayer?.start()
            }
        } else {
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
            if (mediaPlayer?.isPlaying == true){
                mediaPlayer?.pause()
            }
        }
    }

    private fun startTimer(initialMills: Long) { // initialMills 파라미터 추가
        timer = Timer(song.playTime,song.isPlaying, initialMills)
        timer.start()
    }

    inner class Timer(
        private val playTime: Int,
        var isPlaying: Boolean = true,
        initialMills: Long = 0  // 생성자 파라미터 추가
    ): Thread() {
        var second: Int = (initialMills / 1000).toInt()
        var mills: Long = initialMills  // 초기값 설정

        override fun run() {
            super.run()
            try {
                while (true) {
                    if (mills >= playTime * 1000) {
                        if (isRepeatActive) {
                            // 반복 재생이 활성화 되어있으면 처음부터 다시 시작
                            mills = 0
                            second = 0
                            runOnUiThread {
                                binding.songProgressSb.progress = 0
                                binding.songStartTimeTv.text = "00:00"
                                mediaPlayer?.seekTo(0)
                                mediaPlayer?.start()

                                // 반복 재생 시작 시에도 SharedPreferences 업데이트
                                updateSharedPreferences()
                            }
                        } else {
                            runOnUiThread {
                                setPlayerStatus(false)
                            }
                            break
                        }
                    }

                    if (isPlaying) {
                        sleep(50)
                        mills += 50

                        runOnUiThread {
                            // progress를 밀리초 단위로 계산
                            binding.songProgressSb.progress = mills.toInt()

                            // 1초마다 SharedPreferences 업데이트
                            if (mills % 1000 == 0L) {
                                updateSharedPreferences()
                            }
                        }

                        if (mills % 1000 == 0L) {
                            second = (mills / 1000).toInt()
                            runOnUiThread {
                                binding.songStartTimeTv.text = String.format("%02d:%02d", second / 60, second % 60)
                            }
                        }
                    }
                }
            } catch (e: InterruptedException) {
                Log.d("Song", "쓰레드가 죽었습니다. ${e.message}")
            }
        }

        private fun updateSharedPreferences() {
            song.second = (mills / 1000).toInt()
            song.playTime = playTime
            val sharedPreferences = getSharedPreferences("song", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val songJson = gson.toJson(song)
            editor.putString("songData", songJson)
            editor.apply()
        }
    }

    override fun onPause() {
        super.onPause()
        setPlayerStatus(false)
        // 진행 시간 계산 방식 수정
        song.second = (binding.songProgressSb.progress / 1000)  // 밀리초를 초로 변환
        val sharedPreferences = getSharedPreferences("song", MODE_PRIVATE)
        val editor = sharedPreferences.edit() // 에디터
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

}