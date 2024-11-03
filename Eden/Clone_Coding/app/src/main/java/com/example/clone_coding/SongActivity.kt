package com.example.clone_coding

import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.clone_coding.databinding.ActivitySongBinding
import java.util.Locale
import java.util.Timer

class SongActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySongBinding
    private var isRepeatColorChanged = false
    private var isRandomColorChanged = false
    private lateinit var song : Song
    private lateinit var timer: Timer
    private var mediaPlayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSong()
        setPlayer(song)

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


        //재생, 정지 상태 전환
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

    //사용자가 포커스 잃었을 때 음악 중지
    override fun onPause() {
        super.onPause()
        setPlayerStatus(false)
    }

    //스레드 종료
    override fun onDestroy() {
        super.onDestroy()
        timer.interrupt()
        mediaPlayer?.release()  //MediaPlayer가 가지고 있던 리소스 해제
        mediaPlayer = null  //MediaPlayer 해제
    }

    //intent 기반 Song 객체 생성
    private fun initSong(){
        if(intent.hasExtra("title") && intent.hasExtra("singer")){
            song = Song(
                intent.getStringExtra("title")!!,
                intent.getStringExtra("singer")!!,
                intent.getIntExtra("second", 0),
                intent.getIntExtra("playTime",1),   //ArithmeticException 방지 임의 값
                intent.getBooleanExtra("isPlaying", false),
                intent.getStringExtra("music")!!
            )
        }

        startTimer()    //초기화와 동시에 타이머 시작
    }

    //Song 객체 기반 UI 세팅
    private fun setPlayer(song: Song){
        binding.songMusicTitleTv.text = song.title
        binding.songSingerNameTv.text = song.singer
        binding.songStartTimeTv.text = String.format(Locale.US, "%02d:%02d", song.currentTime/60, song.currentTime%60)
        binding.songEndTimeTv.text = String.format(Locale.US, "%02d:%02d", song.playTime/60, song.playTime%60)
        binding.songProgressSb.progress = (song.currentTime*100000/song.playTime)  //Seekbar의 max 값 100000
        val music = R.raw.music_lilac
        mediaPlayer = MediaPlayer.create(this, music)

        setPlayerStatus(song.isPlaying)
    }

    //정지, 재생 상태에 따른 아이콘 변경
    private fun setPlayerStatus (isPlaying : Boolean){
        song.isPlaying = isPlaying
        timer.isPlaying = isPlaying

        if(isPlaying){
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
            mediaPlayer?.start()
        } else {
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
            if(mediaPlayer?.isPlaying == true){
                mediaPlayer?.pause()
            }
        }

    }

    //타이머 시작
    private fun startTimer(){
        timer = Timer(song.playTime, song.isPlaying)
        timer.start()
    }

    //타이머 스레드
    inner class Timer(private val playTime: Int, var isPlaying: Boolean = true):Thread(){
        private var second : Int = 0    //현재 재생 시간(초 단위)
        private var mills : Float = 0f

        override fun run() {
            super.run()

            try {
                while (true){
                    if(second >= playTime){
                        break
                    }

                    if(isPlaying){
                        //50ms 단위로 seekbar 업데이트
                        sleep(50)
                        mills += 50

                        runOnUiThread{
                            binding.songProgressSb.progress = (((mills/1000)/playTime)*100000).toInt()    //진행률을 백분율로 표시
                        }

                        if(mills%1000==0f){
                            //1000ms, 즉 1초 증가 시 UI의 현재 시간 부분 업데이트
                            runOnUiThread {
                                binding.songStartTimeTv.text = String.format(Locale.US, "%02d:%02d", second/60, second%60)
                            }
                            second++
                        }
                    }

                }
            }catch (e: InterruptedException){
                Log.d("song", "쓰레드가 죽었습니다")
            }

        }

    }
}