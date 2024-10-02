package com.example.mission_week1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mission_week1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.happyIv.setOnClickListener{
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
        }

        binding.exitedIv.setOnClickListener{
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
        }

        binding.normalIv.setOnClickListener{
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
        }

        binding.nervousIv.setOnClickListener{
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
        }

        binding.angryIv.setOnClickListener{
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
        }
    }
}