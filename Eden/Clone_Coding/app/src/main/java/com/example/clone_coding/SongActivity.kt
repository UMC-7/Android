package com.example.clone_coding

import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.clone_coding.databinding.ActivitySongBinding
import com.google.gson.Gson
import java.util.Locale

class SongActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySongBinding
    private var isRandomColorChanged = false
    private lateinit var song : Song
    private lateinit var timer: Timer
    private var mediaPlayer : MediaPlayer? = null
    private var gson : Gson = Gson()

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
        val images = listOf(R.drawable.nugu_btn_repeat_inactive, R.drawable.nugu_btn_repeat_all_active, R.drawable.nugu_btn_repeat_one_active) // 사용할 이미지 리스트
        var currentIndex = 0
        binding.songRepeatIv.setOnClickListener {
            currentIndex = (currentIndex + 1) % images.size // 인덱스 순환 설정
            binding.songRepeatIv.setImageResource(images[currentIndex])

            if(currentIndex==2){
                mediaPlayer?.isLooping = true
            }
            else{
                mediaPlayer?.isLooping = false
            }
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

        try {
            binding.songMusicTitleTv.text = song.title
            binding.songSingerNameTv.text = song.singer
            binding.songEndTimeTv.text = String.format(Locale.US, "%d:%02d", (song.playTime) / 60, (song.playTime) % 60)
            Log.d("DEBUG_LOG2", "Song 정보가 레이아웃에 적용되었습니다.")
        } catch (e: Exception) {
            Log.e("DEBUG_LOG2", "레이아웃 적용 중 오류 발생: ${e.message}")
        }
        binding.songAlbumIv.setImageResource(intent.getIntExtra("album_img", R.drawable.img_album_exp2))
    }

    //사용자가 포커스 잃었을 때 음악 중지
    override fun onPause() {
        super.onPause()
        setPlayerStatus(false)
        song.currentTime = ((binding.songProgressSb.progress * song.playTime)/100)/1000 //SeekBar의 현재 위치 받아오기. ms 기준이라 /1000
        val sharedPreferences = getSharedPreferences("song", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val songJson = gson.toJson(song)
        editor.putString("songData", songJson)

        editor.apply()
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
        val songJson = intent.getStringExtra("song_player")
        song = gson.fromJson(songJson, Song::class.java)

        //기본값 설정
        if(song.title=="Unknown"){
            song = Song("Unknown", "Unknown Artist", 0, 1, false, "music_lilac")
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
        mediaPlayer = MediaPlayer.create(this, resources.getIdentifier(song.music, "raw", packageName))

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