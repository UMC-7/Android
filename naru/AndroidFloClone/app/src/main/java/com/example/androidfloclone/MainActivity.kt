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

        inputDummySongs()

        binding.mainPlayerCl.setOnClickListener {
            val editor = getSharedPreferences("song", MODE_PRIVATE).edit()
            editor.putInt("songId", song.id)
            editor.apply()

            val intent = Intent(this, SongActivity::class.java)
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
        val songId = sharedPreferences.getInt("songId", 0)

        val songDB = SongDatabase.getInstance(this)!!

        song = if (songId == 0){
            songDB.songDao().getSong(1)
        } else{
            songDB.songDao().getSong(songId)
        }

        Log.d("song ID", song.id.toString())

        setMiniPlayer(song)
    }

    private fun inputDummySongs() {
        val songDB = SongDatabase.getInstance(this)!!
        val songs = songDB.songDao().getSongs()

        if (songs.isNotEmpty()) return

        songDB.songDao().insert(
            Song("S.A.D", "The Volunteers", 0, 60, false, "music_sad", R.drawable.img_album_exp2, false)
        )
        songDB.songDao().insert(
            Song("Journey", "WOODZ", 0, 60, false, "music_journey", R.drawable.img_album_exp4, false)
        )
        songDB.songDao().insert(
            Song("My World", "아일릿 (ILLIT)", 0, 60, false, "music_myworld", R.drawable.img_album_exp5, false)
        )
        songDB.songDao().insert(
            Song("Butter", "방탄소년단 (BTS)", 0, 60, false, "music_butter", R.drawable.img_album_exp, false)
        )
        songDB.songDao().insert(
            Song("Next Level", "에스파 (AESPA)", 0, 60, false, "music_nextlevel", R.drawable.img_album_exp3, false)
        )
        songDB.songDao().insert(
            Song("Weekend", "태연 (Tae Yeon)", 0, 60, false, "music_weekend", R.drawable.img_album_exp6, false)
        )
        val songDBData = songDB.songDao().getSongs()
        Log.d("DB data", songDBData.toString())
    }

}