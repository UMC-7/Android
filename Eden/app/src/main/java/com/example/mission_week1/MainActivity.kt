package com.example.mission_week1

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setContentView(R.layout.activity_main)

        val happyImageView : ImageView = findViewById(R.id.happy_iv)

        happyImageView.setOnClickListener{
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
        }

        val excitedImageView : ImageView = findViewById(R.id.exited_iv)

        excitedImageView.setOnClickListener{
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
        }

        val normalImageView : ImageView = findViewById(R.id.normal_iv)

        normalImageView.setOnClickListener{
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
        }

        val nervousImageView : ImageView = findViewById(R.id.nervous_iv)

        nervousImageView.setOnClickListener{
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
        }

        val angryImageView : ImageView = findViewById(R.id.angry_iv)

        angryImageView.setOnClickListener{
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
        }






    }
}