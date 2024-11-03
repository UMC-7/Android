package com.example.clone_coding

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.clone_coding.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private var song : Song = Song()
    private var gson : Gson = Gson()

    private val getResultText = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){result->
        if(result.resultCode == Activity.RESULT_OK){
            val returnString = result.data?.getStringExtra("title")
            Toast.makeText(this, returnString, Toast.LENGTH_SHORT).show()

            Log.d("title", "Received result data: $returnString")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // 스플래시 화면 설치(실행 시간 연장용)
        val splashScreen = installSplashScreen()

        // 스플래시 화면 지연 시간 설정
        splashScreen.setKeepOnScreenCondition { true }
        Handler(Looper.getMainLooper()).postDelayed({
            splashScreen.setKeepOnScreenCondition { false }
        }, 1000) // 1초 지연

        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FLO)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()

        val song = Song(
            binding.mainMiniplayerTitleTv.text.toString(), binding.mainMiniplayerSingerTv.text.toString(),
            0, 60, false, "music_lilac"
        )

        // 플레이어 띄울 때 데이터 전달
        binding.mainPlayerCl.setOnClickListener {
            val intent = Intent(this, SongActivity::class.java)
            intent.putExtra("title", song.title)
            intent.putExtra("singer", song.singer)
            intent.putExtra("currentTime", song.currentTime)
            intent.putExtra("playTime", song.playTime)
            intent.putExtra("isPlaying", song.isPlaying)
            intent.putExtra("music", song.music)

            getResultText.launch(intent)
        }
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

    private fun setMiniPlayer(song:Song){
        binding.mainMiniplayerTitleTv.text = song.title
        binding.mainMiniplayerSingerTv.text = song.singer
        binding.mainProgressSb.progress = (song.currentTime*100000)/song.playTime
    }

    override fun onStart() {
        super.onStart()
        val sharedPreferences = getSharedPreferences("song", MODE_PRIVATE)
        val songJson = sharedPreferences.getString("songData", null)

        song = if(songJson == null){
            Song("라일락", "아이유(IU)", 0, 60, false, "music_lilac")
        }else{
            gson.fromJson(songJson, Song::class.java)
        }

        setMiniPlayer(song)
    }



}