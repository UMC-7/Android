package com.example.roomdbpractice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdbpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var list = ArrayList<Profile>()
    lateinit var customAdapter: CustomAdapter
    lateinit var db: ProfileDatabase

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = ProfileDatabase.getInstance(this)!!

        // 초기화: 데이터를 Thread 외부에서 가져오고 UI 스레드에서 처리
        customAdapter = CustomAdapter(list, this)
        binding.mainProfileLv.adapter = customAdapter

        // Thread에서 데이터 로드
        Thread {
            val savedContacts = db.profileDao().getAll()
            if (savedContacts.isNotEmpty()) {
                runOnUiThread {
                    list.addAll(savedContacts)
                    customAdapter.notifyDataSetChanged() // 어댑터 갱신
                }
            }
        }.start()

        // 버튼 클릭시 새 프로필 추가
        binding.button.setOnClickListener {
            Thread {
                val newProfile = Profile("양지애", "21", "4277")
                list.add(newProfile)  // 리스트에 추가
                db.profileDao().insert(newProfile)  // DB에 저장

                val insertedProfile = db.profileDao().getAll()
                Log.d("Inserted Primary Key", insertedProfile.last().id.toString())
                runOnUiThread {
                    customAdapter.notifyDataSetChanged()  // 어댑터 갱신
                }
            }.start()
        }
    }
}
