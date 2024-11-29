package com.example.androidfloclone

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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

        inputDummyAlbums()
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

    fun albumSongsReceived(jsonData: String) {
        val gson = Gson()
        val songId = gson.fromJson(jsonData, Array<Int>::class.java)
        val songIdList: ArrayList<Int> = ArrayList(songId.toList())

        songDB = SongDatabase.getInstance(this)!!

        for(i in 0 until songIdList.size) {
            songs.add(songDB.songDao().getSong(songIdList[i]))
        }

        nowPos = songs.size - songIdList.size

        setMiniPlayer(songs[nowPos])
        Log.d("AlbumSongs", "Loaded songs: $songs")

        // SharedPreferences에서 기존에 저장된 수록곡 ID 리스트를 불러오기
        val sharedPreferences = getSharedPreferences("SongPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        val existingIdsJson = sharedPreferences.getString("songIds", "[]")
        val existingIdsArray = gson.fromJson(existingIdsJson, Array<Int>::class.java)
        val existingIdsList = ArrayList(existingIdsArray.toList())

        // 새로운 앨범의 수록곡을 기존 리스트에 추가
        existingIdsList.addAll(songIdList)

        // 새로운 리스트를 JSON으로 변환하여 저장
        val updatedSongIdsJson = gson.toJson(existingIdsList)
        editor.putString("songIds", updatedSongIdsJson)

        // 데이터 저장
        editor.apply()

        Log.d("mainAlbumId", songs.toString())
    }

/*
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
*/

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

    private fun inputDummyAlbums() {
        val songDB = SongDatabase.getInstance(this)!!
        val songs = songDB.albumDao().getAlbums()

        if (songs.isNotEmpty()) return

        songDB.albumDao().insert(
            Album(1, "The Volunteers", "The Volunteers (더 발룬티어스)", R.drawable.img_album_exp2)
        )
        songDB.albumDao().insert(
            Album(2, "OO-LI", "WOODZ", R.drawable.img_album_exp4)
        )
        songDB.albumDao().insert(
            Album(3,"SUPER REAL ME", "아일릿 (ILLIT)", R.drawable.img_album_exp5)
        )
        songDB.albumDao().insert(
            Album(4, "Butter", "방탄소년단 (BTS)", R.drawable.img_album_exp)
        )
        songDB.albumDao().insert(
            Album(5, "Next Level", "에스파 (AESPA)", R.drawable.img_album_exp3)
        )
        songDB.albumDao().insert(
            Album(6, "Weekend", "태연 (Tae Yeon)", R.drawable.img_album_exp6)
        )
    }

    private fun inputDummySongs() {
        val songDB = SongDatabase.getInstance(this)!!
        val songs = songDB.songDao().getSongs()

        if (songs.isNotEmpty()) return

        songDB.songDao().insert(
            Song("S.A.D", "The Volunteers", 0, 60, false, "music_sad", R.drawable.img_album_exp2, false, 1)
        )
        songDB.songDao().insert(
            Song("Summer", "The Volunteers", 0, 60, false, "music_sad", R.drawable.img_album_exp2, false, 1)
        )
        songDB.songDao().insert(
            Song("Journey", "WOODZ", 0, 60, false, "music_journey", R.drawable.img_album_exp4, false, 2)
        )
        songDB.songDao().insert(
            Song("Drowning", "WOODZ", 0, 60, false, "music_journey", R.drawable.img_album_exp4, false, 2)
        )
        songDB.songDao().insert(
            Song("My World", "아일릿 (ILLIT)", 0, 60, false, "music_myworld", R.drawable.img_album_exp5, false, 3)
        )
        songDB.songDao().insert(
            Song("Busted", "WOODZ", 0, 60, false, "music_journey", R.drawable.img_album_exp4, false, 2)
        )
        songDB.songDao().insert(
            Song("Lucky Girl Syndrome", "아일릿 (ILLIT)", 0, 60, false, "music_myworld", R.drawable.img_album_exp5, false, 3)
        )
        songDB.songDao().insert(
            Song("Midnight Fiction", "아일릿 (ILLIT)", 0, 60, false, "music_myworld", R.drawable.img_album_exp5, false, 3)
        )
        songDB.songDao().insert(
            Song("Butter", "방탄소년단 (BTS)", 0, 60, false, "music_butter", R.drawable.img_album_exp, false, 4)
        )
        songDB.songDao().insert(
            Song("Magnetic", "아일릿 (ILLIT)", 0, 60, false, "music_myworld", R.drawable.img_album_exp5, false, 3)
        )
        songDB.songDao().insert(
            Song("Next Level", "에스파 (AESPA)", 0, 60, false, "music_nextlevel", R.drawable.img_album_exp3, false, 5)
        )
        songDB.songDao().insert(
            Song("Weekend", "태연 (Tae Yeon)", 0, 60, false, "music_weekend", R.drawable.img_album_exp6, false, 6)
        )
        songDB.songDao().insert(
            Song("Violet", "The Volunteers", 0, 60, false, "music_sad", R.drawable.img_album_exp2, false, 1)
        )
        val songDBData = songDB.songDao().getSongs()
        Log.d("DB data", songDBData.toString())
    }

}