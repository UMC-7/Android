package com.example.androidfloclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.androidfloclone.R
import com.example.androidfloclone.databinding.ActivityMainBinding
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var song: Song = Song()
    private var gson: Gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainPlayerCl.setOnClickListener {
            // 제목을 텍스트뷰에서 가져옴
            val songTitle = binding.mainMiniplayerTitleTv.text.toString()
            val songSinger = binding.mainMiniplayerSingerTv.text.toString()

            // SongActivity로 이동하는 Intent 생성
            val intent = Intent(this, SongActivity::class.java).apply {
                putExtra("title", songTitle)
                putExtra("singer", songSinger)
                putExtra("second", song.second)
                putExtra("playTime", song.playTime)
                putExtra("isPlaying", song.isPlaying)
                putExtra("music", song.music)
            }
            // SongActivity 시작
            startActivity(intent)
        }

        initBottomNavigation()

        Log.d("Song", song.title + song.singer)

    }

    private fun initBottomNavigation(){

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()

        binding.mainBnv.setOnItemSelectedListener{ item ->
            when (item.itemId) {

                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.lookFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, LookFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.searchFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, SearchFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.lockerFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, LockerFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }

    private fun setMiniPlayer(song: Song) {
        binding.mainMiniplayerTitleTv.text = song.title
        binding.mainMiniplayerSingerTv.text = song.singer
        binding.mainProgressSb.progress = (song.second * 100000 / song.playTime)
    }

    fun updateMiniPlayer(album: Album) {
        // 앨범의 첫 번째 노래를 선택
        val firstSong = album.songs?.first()

        // 미니 플레이어에 앨범 정보와 첫 번째 노래 정보 업데이트
        if (firstSong != null) {
            binding.mainMiniplayerTitleTv.text = firstSong.title
            binding.mainMiniplayerSingerTv.text = firstSong.singer
        }
        binding.mainProgressSb.progress = 0  // 프로그레스바 초기화
    }

    override fun onStart() {
        super.onStart()
        val sharedPreferences = getSharedPreferences("song", MODE_PRIVATE)
        val jsonToSong = sharedPreferences.getString("songData", null)

        song = if(jsonToSong == null) { // 최초 실행 시
            Song("S.A.D", "The Volunteers", 0, 60, false, "music_sad")
        } else { // SongActivity에서 노래가 한번이라도 pause 된 경우
            gson.fromJson(jsonToSong, Song::class.java)
        }
        setMiniPlayer(song)
    }
}