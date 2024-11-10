package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityCheckBinding

class CheckActivity: AppCompatActivity() {
    lateinit var binding: ActivityCheckBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val gettext = intent.getStringExtra("textkey")

        binding.emptyCheckActivityTv.text = gettext;
        binding.backCheckActivityBt.setOnClickListener {
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}