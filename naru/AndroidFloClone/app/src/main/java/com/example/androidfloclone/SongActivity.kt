package com.example.androidfloclone

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidfloclone.databinding.ActivitySongBinding
import com.google.gson.Gson

class SongActivity : AppCompatActivity() {
    lateinit var binding: ActivitySongBinding
    lateinit var timer: Timer
    private var mediaPlayer: MediaPlayer? = null

    val songs = arrayListOf<Song>()
    lateinit var songDB: SongDatabase
    var nowPos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPlayList()
        initSong()
        initClickListener()
    }

    private fun initPlayList() {
        songDB = SongDatabase.getInstance(this)!!
        songs.addAll(songDB.songDao().getSongs())
    }

    private fun initClickListener() {
        // 버튼 클릭 시 제목 전달하고 액티비티 종료
        binding.songDownIb.setOnClickListener {
            finish()
        }

        binding.songMiniplayerIv.setOnClickListener {
            setPlayerStatus(true)
            startStopService()
        }
        binding.songPauseIv.setOnClickListener {
            setPlayerStatus(false)
            startStopService()
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
            binding.songRepeatOneIv.visibility = View.GONE
        }
        binding.songRepeatActiveIv.setOnClickListener {
            binding.songRepeatIv.visibility = View.GONE
            binding.songRepeatActiveIv.visibility = View.GONE
            binding.songRepeatOneIv.visibility = View.VISIBLE
        }
        binding.songRepeatOneIv.setOnClickListener {
            binding.songRepeatIv.visibility = View.VISIBLE
            binding.songRepeatActiveIv.visibility = View.GONE
            binding.songRepeatOneIv.visibility = View.GONE
        }

        binding.songNextIv.setOnClickListener {
            moveSong(+1)
        }
        binding.songPreviousIv.setOnClickListener {
            moveSong(-1)
        }
    }

    private fun initSong() {
        val spf = getSharedPreferences("song", MODE_PRIVATE)
        val songId = spf.getInt("songId", 0)
        nowPos = getPlayingSongPosition(songId)

        startTimer()
        setPlayer(songs[nowPos])
    }

    private fun moveSong(direct: Int) {
        if (nowPos + direct < 0) {
            Toast.makeText(this, "first song", Toast.LENGTH_SHORT).show()
            return
        }
        if (nowPos + direct >= songs.size) {
            Toast.makeText(this, "Last song", Toast.LENGTH_SHORT).show()
            return
        }

        nowPos += direct

        timer.interrupt()
        startTimer()

        mediaPlayer?.release()
        mediaPlayer = null

        setPlayer(songs[nowPos])
    }

    private fun getPlayingSongPosition(songId: Int): Int {
        for (i in 0 until songs.size) {
            if (songs[i].id == songId) {
                return i
            }
        }
        return 0
    }

    private fun setPlayer(song: Song) {
        binding.songMusicTitleTv.text = song.title
        binding.songSingerNameTv.text = song.singer
        binding.songStartTimeTv.text = String.format("%02d:%02d", song.second / 60, song.second % 60)
        binding.songEndTimeTv.text = String.format("%02d:%02d", song.playTime / 60, song.playTime % 60)
        binding.songAlbumIv.setImageResource(song.coverImg!!)
        binding.songProgressSb.progress = (song.second * 1000 / song.playTime)

        val music = resources.getIdentifier(song.music, "raw", this.packageName)
        mediaPlayer = MediaPlayer.create(this, music)

        setPlayerStatus(song.isPlaying)
    }

    // 플레이 상태를 설정하는 함수
    fun setPlayerStatus(isPlaying : Boolean) {
        songs[nowPos].isPlaying = isPlaying
        timer.isPlaying = isPlaying

        if (isPlaying) {
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
            mediaPlayer?.start()
        }
        else {
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
            if (mediaPlayer?.isPlaying == true) {
                mediaPlayer?.pause()
            }
        }
    }

    private fun startTimer() {
        timer = Timer(songs[nowPos].playTime, songs[nowPos].isPlaying)
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
                        if (binding.songRepeatOneIv.visibility == View.VISIBLE) {
                            // 한곡 재생 모드일 때만 시간과 SeekBar 초기화
                            second = 0
                            mills = 0f
                            runOnUiThread {
                                binding.songStartTimeTv.text = String.format("%02d:%02d", second / 60, second % 60)
                                binding.songProgressSb.progress = 0
                            }
                            // 노래를 처음으로 되돌림
                            mediaPlayer?.seekTo(0)
                            mediaPlayer?.start()  // 처음부터 재생 시작

                        } else {
                            mediaPlayer?.release() // 미디어 플레이어가 갖고 있던 리소스 해제
                            mediaPlayer = null // 미디어 플레이어 해제
                            break // 한곡 재생 모드가 아닐 때 타이머 종료
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
                Log.d("Song", "스레드가 중지되었습니다: ${e.message}")
            }
        }
    }
    // 사용자가 포커스를 잃었을 때 음악이 중지
    override fun onPause() {
        super.onPause()
        setPlayerStatus(false)

        songs[nowPos].second = ((binding.songProgressSb.progress * songs[nowPos].playTime)/100)/1000
        val sharedPreferences = getSharedPreferences("song", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("songId", songs[nowPos].id)
        editor.apply()
    }
    override fun onDestroy() {
        super.onDestroy()
        timer.interrupt()
        mediaPlayer?.release() // 미디어 플레이어가 갖고 있던 리소스 해제
        mediaPlayer = null // 미디어 플레이어 해제
    }

    private fun startStopService() {
        if (isServiceRunning(MusicService::class.java)) { // 서비스가 실행 중인지 확인
            Toast.makeText(this, "Foreground Service Stopped", Toast.LENGTH_SHORT).show()
            val stopped = stopService(Intent(this, MusicService::class.java))
            if (!stopped) {
                Toast.makeText(this, "Failed to stop Foreground Service", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Foreground Service Started", Toast.LENGTH_SHORT).show()
            val startedIntent = Intent(this, MusicService::class.java)
            val started = startService(startedIntent) != null
            if (!started) {
                Toast.makeText(this, "Failed to start Foreground Service", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isServiceRunning(inputClass : Class<MusicService>) : Boolean {
        val manager : ActivityManager = getSystemService(
            Context.ACTIVITY_SERVICE
        ) as ActivityManager

        for (service : ActivityManager.RunningServiceInfo in manager.getRunningServices(Integer.MAX_VALUE)) {
            if (inputClass.name.equals(service.service.className)) {
                return true
            }
        }
        return false
    }
}