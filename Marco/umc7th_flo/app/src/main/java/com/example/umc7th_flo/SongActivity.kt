package com.example.umc7th_flo

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.umc7th_flo.databinding.ActivitySongBinding
import com.google.gson.Gson

class SongActivity : AppCompatActivity() {
    //소괄호 : 클래스를 다른 클래스로 상속을 진행할 때는 소괄호를 넣어줘야 한다.

    //전역 변수
    lateinit var binding : ActivitySongBinding

    lateinit var song : Song
    lateinit var timer : Timer
    private var playOption = 0  // 반복 재생 옵션, 0 = 일반재생, 1 = 반복재생, 2 = 한곡반복재생

    private var mediaPlayer : MediaPlayer?= null
    private var gson : Gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSong()

        // MainActivity에서 전달받은 값 받아서 반영
        setPlayer(song)

        // MainActivity로 앨범 텍스트 전달
        binding.songDownIb.setOnClickListener {
            val intent2 = Intent(this, MainActivity::class.java)
            intent2.putExtra("title", intent.getStringExtra("title"))
            setResult(RESULT_OK, intent2)
            finish()
        }

        binding.songMiniplayerIv.setOnClickListener {
            setPlayerStatus(true)
        }
        binding.songPauseIv.setOnClickListener {
            setPlayerStatus(false)
        }

        // 반복재생 옵션 설정
        binding.songRepeatIv.setOnClickListener {
            binding.songRepeatIv.visibility = View.GONE
            binding.songRepeatOnIv.visibility = View.VISIBLE
            binding.songRepeatOneIv.visibility = View.GONE
            playOption = 1
        }
        binding.songRepeatOnIv.setOnClickListener {
            binding.songRepeatIv.visibility = View.GONE
            binding.songRepeatOnIv.visibility = View.GONE
            binding.songRepeatOneIv.visibility = View.VISIBLE
            playOption = 2
        }
        binding.songRepeatOneIv.setOnClickListener {
            binding.songRepeatIv.visibility = View.VISIBLE
            binding.songRepeatOnIv.visibility = View.GONE
            binding.songRepeatOneIv.visibility = View.GONE
            playOption = 0
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

    // 포커스를 잃을 때 음악 중지
    override fun onPause() {
        super.onPause()
        setPlayerStatus(false)

        // 노래 진행 상황 저장 (재생시간)
        song.second = ((binding.songProgressSb.progress * song.playTime)/100)/1000  // 밀리세컨드로 계산
        val sharedPreferences = getSharedPreferences("song", MODE_PRIVATE)
        val editor = sharedPreferences.edit()   // 에디터 선언
        val songJson = gson.toJson(song)    // song 객체를 json 포맷으로 변경
        editor.putString("songData", songJson)
        editor.apply()
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.interrupt()
        mediaPlayer?.release()  // 미디어플레이어가 갖고있던 리소스 해제
        mediaPlayer = null  // 미디어플레이어 해제
    }

    private fun initSong() {
        if(intent.hasExtra("title") && intent.hasExtra("singer")){
            song = Song(
                intent.getStringExtra("title")!!,
                intent.getStringExtra("singer")!!,
                intent.getIntExtra("second", 0),
                intent.getIntExtra("playTime", 0),
                intent.getBooleanExtra("isPlaying", false),
                intent.getStringExtra("music")!!
            )
        }
        startTimer()
    }

    private fun setPlayer(song: Song){
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
            if(mediaPlayer?.isPlaying == true) {
                mediaPlayer?.pause()
            }
        }
    }

    private fun startTimer() {
        timer = Timer(song.playTime, song.isPlaying)
        timer.start()
    }

    inner class Timer(private val playTime: Int, var isPlaying: Boolean = true) : Thread() {
        private var second: Int = 0
        private var mills: Float = 0f

        override fun run() {
            super.run()
            try {
                while (true) {
                    if (second >= playTime) {
                        when(playOption) {
                            0 -> {
                                runOnUiThread {
                                    setPlayerStatus(false)
                                }
                                break
                            }
                            1, 2 -> {
                                mediaPlayer?.seekTo(0)
                                second = 0
                                mills = 0f
                                runOnUiThread {
                                    binding.songProgressSb.progress = 0
                                    binding.songStartTimeTv.text = "00:00"
                                }
                            }
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
}