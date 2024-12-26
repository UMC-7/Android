package com.example.week6

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.week6.databinding.ActivityMainBinding

private lateinit var binding :ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            //초기화면 로딩 ; Home
            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainerView.id, HomeFragment())
                .commit()
        }
    }
}