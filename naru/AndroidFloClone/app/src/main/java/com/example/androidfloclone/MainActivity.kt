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
    val songs = arrayListOf<Song>()
    lateinit var songDB: SongDatabase
    var nowPos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inputDummySongs()
        initPlayList()
        initClickListener()

        binding.mainPlayerCl.setOnClickListener {
            val editor = getSharedPreferences("song", MODE_PRIVATE).edit()
            editor.putInt("songId", songs[nowPos].id)
            editor.apply()

            val intent = Intent(this, SongActivity::class.java)
            startActivity(intent)
        }

        initBottomNavigation()

        Log.d("Song", songs[nowPos].title + songs[nowPos].singer)

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

    private fun getPlayingSongPosition(songId: Int): Int {
        for (i in 0 until songs.size) {
            if (songs[i].id == songId) {
                return i
            }
        }
        return 0
    }

    private fun initPlayList() {
        songDB = SongDatabase.getInstance(this)!!
        songs.addAll(songDB.songDao().getSongs())
    }

    private fun initClickListener() {
        binding.mainPreviousBtn.setOnClickListener {
            moveSong(-1)
        }
        binding.mainNextBtn.setOnClickListener {
            moveSong(+1)
        }
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

        setMiniPlayer(songs[nowPos])
        binding.mainProgressSb.progress = 0
    }

    private fun setMiniPlayer(song: Song) {
        binding.mainMiniplayerTitleTv.text = song.title
        binding.mainMiniplayerSingerTv.text = song.singer
        val sharedPreferences = getSharedPreferences("song", MODE_PRIVATE)
        val second = sharedPreferences.getInt("second", 0)
        binding.mainProgressSb.progress = (second * 100000 / song.playTime)
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

        // songId에 해당하는 노래가 있으면 그 노래를 리스트에서 찾아서 해당 위치를 설정
        val songPosition = getPlayingSongPosition(songId)

        if (songPosition >= 0 && songPosition < songs.size) {
            nowPos = songPosition
        } else {
            // songId가 없거나 잘못된 경우 기본 첫 번째 노래 설정
            nowPos = 0
        }

        // 선택된 노래로 미니 플레이어 업데이트
        setMiniPlayer(songs[nowPos])

        Log.d("song ID", songs[nowPos].id.toString())
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