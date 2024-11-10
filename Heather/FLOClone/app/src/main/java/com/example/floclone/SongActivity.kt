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

//    private var isRepeatActive = false
//    private var isRandomActive = false

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
        startTimer()
    }

    private fun setPlayer(song: Song) {
        binding.songMusicTitleTv.text = intent.getStringExtra("title")!!
        binding.songSingerNameTv.text = intent.getStringExtra("singer")!!
        binding.songStartTimeTv.text = String.format("%02d:%02d",song.second / 60, song.second % 60)
        binding.songEndTimeTv.text = String.format("%02d:%02d",song.playTime / 60, song.playTime % 60)
        binding.songProgressSb.progress = (song.second * 1000 / song.playTime)
        val music = resources.getIdentifier(song.music, "raw", this.packageName)
        mediaPlayer = MediaPlayer.create(this, music)
        setPlayerStatus(song.isPlaying)
    }

    private fun setPlayerStatus(isPlaying: Boolean) {
        song.isPlaying = isPlaying
        timer.isPlaying = isPlaying

        if (isPlaying) {
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
            mediaPlayer?.start()
        } else {
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
            if (mediaPlayer?.isPlaying == true){
                mediaPlayer?.pause()
            }
        }
    }

    private fun startTimer() {
        timer = Timer(song.playTime,song.isPlaying)
        timer.start()
    }

    inner class Timer(private val playTime: Int, var isPlaying: Boolean = true): Thread() {
        private var second : Int = 0
        private var mills: Float = 0f

        override fun run() {
            super.run()
            try {
                while (true) {
                    if (second >= playTime){
                        break
                    }

                    if (isPlaying){
                        sleep(50)
                        mills += 50

                        runOnUiThread {
                            binding.songProgressSb.progress = ((mills / playTime)*100).toInt()
                        }

                        if (mills % 1000 == 0f){
                            runOnUiThread {
                                binding.songStartTimeTv.text = String.format("%02d:%02d",second / 60, second % 60)
                            }
                            second++
                        }
                    }
                }

            } catch (e: InterruptedException){
                Log.d("Song","쓰레드가 죽었습니다. ${e.message}")
            }
        }
    }

    override fun onPause() {
        super.onPause()
        setPlayerStatus(false)
        song.second = ((binding.songProgressSb.progress * song.playTime)/100)/1000
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


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivitySongBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        // 내리기 버튼 클릭 시 현재 액티비티 종료
//        binding.songDownIb.setOnClickListener {
//            returnSongTitle()  // 앨범 제목 반환
//            finish()
//        }
//
//        binding.songMiniplayerIv.setOnClickListener {
//            setPlayerStatus(false)
//        }
//        binding.songPauseIv.setOnClickListener {
//            setPlayerStatus(true)
//        }
//
//        // 반복 재생 버튼 클릭 리스너 추가
//        binding.songRepeatIv.setOnClickListener {
//            isRepeatActive = !isRepeatActive
//            if (isRepeatActive) {
//                binding.songRepeatIv.setColorFilter(
//                    ContextCompat.getColor(this, R.color.select_color),
//                    PorterDuff.Mode.SRC_IN
//                )
//            } else {
//                binding.songRepeatIv.clearColorFilter()
//            }
//        }
//
//        // 랜덤 재생 버튼 클릭 리스너 추가
//        binding.songRandomIv.setOnClickListener {
//            isRandomActive = !isRandomActive
//            if (isRandomActive) {
//                binding.songRandomIv.setColorFilter(
//                    ContextCompat.getColor(this, R.color.select_color),
//                    PorterDuff.Mode.SRC_IN
//                )
//            } else {
//                binding.songRandomIv.clearColorFilter()
//            }
//        }
//
//        // MainActivity에서 전달받은 노래 제목과 가수 이름으로 TextView 값 변경
//        if (intent.hasExtra("title") && intent.hasExtra("singer")) {
//            binding.songMusicTitleTv.text = intent.getStringExtra("title")
//            binding.songSingerNameTv.text = intent.getStringExtra("singer")
//        }
//
//        // SeekBar 설정
//        binding.songProgressSb.max = 60000 // 1분
//        updateSeekBar()
//
//        binding.songProgressSb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
//            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                binding.songStartTimeTv.text = String.format("%02d:%02d",
//                    TimeUnit.MILLISECONDS.toMinutes(progress.toLong()),
//                    TimeUnit.MILLISECONDS.toSeconds(progress.toLong()) % 60)
//            }
//            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
//            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
//        })
//    }
//
//    // 재생 버튼의 상태를 바꿔주는 메서드
//    fun setPlayerStatus(isPlaying : Boolean) {
//        if (isPlaying) {
//            binding.songMiniplayerIv.visibility = View.VISIBLE
//            binding.songPauseIv.visibility = View.GONE
//        } else {
//            binding.songMiniplayerIv.visibility = View.GONE
//            binding.songPauseIv.visibility = View.VISIBLE
//        }
//    }
//
//    // 노래 제목을 MainActivity로 반환하는 메서드
//    private fun returnSongTitle() {
//        val returnIntent = Intent()
//        val songTitle = binding.songMusicTitleTv.text.toString()
//        returnIntent.putExtra("songTitle", songTitle)
//        setResult(RESULT_OK, returnIntent)
//    }
//
//
//    private fun updateSeekBar() {
//        val handler = Handler(Looper.getMainLooper())
//        handler.postDelayed(object : Runnable {
//            override fun run() {
//                if(binding.songMiniplayerIv.visibility == View.GONE) { // 음악이 재생 중일 때
//                    val currentPosition = binding.songProgressSb.progress + 1000 // 1초씩 증가
//                    binding.songProgressSb.progress = currentPosition
//                }
//                handler.postDelayed(this, 1000)
//            }
//        }, 1000)
//    }
//
//    override fun onBackPressed() {
//        returnSongTitle()  // 뒤로가기 눌렀을 때도 데이터 반환
//        super.onBackPressed()
//    }

}