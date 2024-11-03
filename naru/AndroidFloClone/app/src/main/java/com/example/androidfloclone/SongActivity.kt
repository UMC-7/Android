package com.example.androidfloclone

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.androidfloclone.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {

    lateinit var binding: ActivitySongBinding
    lateinit var song: Song
    lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSong()
        setPlayer(song)

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

        binding.songMiniplayerIv.setOnClickListener {
            setPlayerStatus(true)
        }
        binding.songPauseIv.setOnClickListener {
            setPlayerStatus(false)
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
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.interrupt()
    }

    private fun initSong() {
        if(intent.hasExtra("title") && intent.hasExtra("singer")) {
            song = Song(
                intent.getStringExtra("title")!!,
                intent.getStringExtra("singer")!!,
                intent.getIntExtra("second", 0),
                intent.getIntExtra("playTime", 0),
                intent.getBooleanExtra("isPlaying", false)
            )
        }
        startTimer()
    }

    private fun setPlayer(song: Song) {
        binding.songMusicTitleTv.text = intent.getStringExtra("title")
        binding.songSingerNameTv.text = intent.getStringExtra("singer")
        binding.songStartTimeTv.text = String.format("%02d:%02d", song.second / 60, song.second % 60)
        binding.songEndTimeTv.text = String.format("%02d:%02d", song.playTime / 60, song.playTime % 60)
        binding.songProgressSb.progress = (song.second * 1000 / song.playTime)

        setPlayerStatus(song.isPlaying)
    }

    // 플레이 상태를 설정하는 함수
    fun setPlayerStatus(isPlaying : Boolean) {
        song.isPlaying = isPlaying
        timer.isPlaying = isPlaying

        if (isPlaying) {
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
        }
        else {
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
        }
    }

    private fun startTimer() {
        timer = Timer(song.playTime, song.isPlaying)
        timer.start()
    }

    inner class Timer(private val playTime: Int, var isPlaying: Boolean = true): Thread() {
        private var second : Int = 0
        private var mills : Float = 0f

        override fun run() {
            super.run()
            try {
                while (true) {
                    if (second >= playTime) {
                        break
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
            }catch (e: InterruptedException) {
                Log.d("Song", "스레드가 죽었습니다 ${e.message}")
            }

        }
    }
}