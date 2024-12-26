package com.example.week5

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.week5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var memo : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onPause() {
        super.onPause()
        memo = binding.mainMemoEt.getText().toString()  //작성 중이던 내용 저장
        Log.d("save-pause", memo)
    }

    override fun onResume() {
        super.onResume()
        if(memo!=""){
            //저장된 내용이 있다면 set
            binding.mainMemoEt.setText(memo)
            Log.d("save-resume", memo)
        }
    }
}