package com.example.floclone

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.floclone.databinding.ActivityMainBinding
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var song: Song = Song()
    private var gson: Gson = Gson()


//     ActivityResultLauncher 설정
//    private val songActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//        if (result.resultCode == RESULT_OK) {
//            val songTitle = result.data?.getStringExtra("songTitle")
//            songTitle?.let {
//                Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(3000)
        installSplashScreen()

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()

        binding.mainPlayerCl.setOnClickListener {
            val intent = Intent(this, SongActivity::class.java)
        }

        binding.mainPlayerCl.setOnClickListener {
            val intent = Intent(this, SongActivity::class.java)
            intent.putExtra("title", song.title)
            intent.putExtra("singer", song.singer)
            intent.putExtra("second", song.second)
            intent.putExtra("playTime", song.playTime)
            intent.putExtra("isPlaying", song.isPlaying)
            intent.putExtra("music", song.music)
            startActivity(intent)
        }

//        binding.mainPlayerCl.setOnClickListener {
//            //startActivity(Intent(this, SongActivity::class.java))
//
//            // 미니플레이어 클릭 시 SongActivity로 이동하면서 노래 제목과 가수 이름 전달
//            val intent = Intent(this, SongActivity::class.java)
//            intent.putExtra("title", song.title)
//            intent.putExtra("singer", song.singer)
//            songActivityLauncher.launch(intent)
//        }
//
//        initBottomNavigation()
//
//        Log.d("Song", song.title + song.singer)

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
                        .replace(R.id.main_frm, LockFragment())
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

    private fun setMiniPlayer(song : Song) {
        binding.mainMiniplayerTitleTv.text = song.title
        binding.mainMiniplayerSingerTv.text = song.singer
        binding.mainMiniplayerProgressSb.progress = (song.second*100000)/song.playTime
    }

    override fun onStart() {
        super.onStart()
        val sharedPreferences = getSharedPreferences("song", MODE_PRIVATE)
        val songJson = sharedPreferences.getString("songData", null)

        song = if (songJson == null) {
            Song("라일락", "아이유(IU)", 0,60, false, "relaxing_piano_music")
        } else {
            gson.fromJson(songJson, Song::class.java)
        }

        setMiniPlayer(song)
    }
}