package com.example.flo_clone_umc_bottom

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.flo_clone_umc_bottom.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var song: Song = Song()
    private var gson: Gson = Gson()

    val getResultText = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val albumTitle = result.data?.getStringExtra("ALBUM_TITLE")
            Toast.makeText(this,albumTitle, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Flo_Clone_UMC_Bottom)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val song = Song(binding.mainMiniplayerTitleTv.text.toString(), binding.mainMiniplayerSingerTv.text.toString(),0,60,false,"music_lilac")
        //6주차 정보가 계속 초기화 되어서 들어가는 문제를 해결

        binding.mainPlayerCl.setOnClickListener {
            //startActivity(Intent(this, SongActivity::class.java))
            val intent = Intent(this, SongActivity::class.java)
            intent.putExtra("title", song.title)
            intent.putExtra("singer", song.singer)
            intent.putExtra("second", song.second)
            intent.putExtra("playTime", song.playTime)
            intent.putExtra("isPlaying", song.isPlaying)
            intent.putExtra("music", song.music)
            intent.putExtra("coverImg", song.coverImg)
            getResultText.launch(intent)
        }




        initBottomNavigation()

        Log.d("Song",song.title + song.singer)
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


    private fun setMiniPlayer(song: Song){
        binding.mainMiniplayerTitleTv.text = song.title
        binding.mainMiniplayerSingerTv.text = song.singer
        binding.mainMiniplayerProgressSb.progress = (song.second*100000)/song.playTime

    }

    fun updateMiniPlayer(album: Album) {
        song = Song(
            title = album.title,
            singer = album.singer,
            second = 0,
            playTime = 60,
            isPlaying = false,
            music = "music_lilac",
            coverImg = album.coverImg
        )
        //6주차 SongActivity로 정보 전달을 위한 song 변수 초기화

        binding.mainMiniplayerTitleTv.text = album.title
        binding.mainMiniplayerSingerTv.text = album.singer
        binding.mainMiniplayerProgressSb.progress = (song.second*100000)/song.playTime
        binding.mainPlayerCl.visibility = View.VISIBLE // 미니 플레이어 표시
    }
    //6주차 미니 플레이어 업데이트

    override fun onStart() {
        super.onStart()
        val sharedPreferences = getSharedPreferences("song", MODE_PRIVATE)
        val songJson = sharedPreferences.getString("songData",null )

        song = if(songJson == null){
            Song("라일락", "아이유(IU)", 0, 60, false, "music_lilac", R.drawable.img_album_exp2)
        } else {
            gson.fromJson(songJson, Song::class.java)
        }

        setMiniPlayer(song)


    }
}