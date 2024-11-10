package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMemoBinding

class MemoActivity: AppCompatActivity() {
    lateinit var binding: ActivityMemoBinding
    var text = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.checkMemoActivityBt.setOnClickListener {
            val gettext = binding.textfieldMemoActivityEt.text.toString()
            val intent = Intent(this, CheckActivity::class.java)
            intent.putExtra("textkey",gettext)
            startActivity(intent)

        }
    }

    override fun onPause() {
        super.onPause()
        text = binding.textfieldMemoActivityEt.text.toString()
    }

    override fun onResume() {
        super.onResume()
        binding.textfieldMemoActivityEt.setText(text)
    }

    override fun onRestart() {
        super.onRestart()
        val builder = AlertDialog.Builder(this)
        builder.setTitle("다시 작성하시겠습니까?")
        builder.setPositiveButton("다시 작성"){ dialog, which ->
            text = ""
            binding.textfieldMemoActivityEt.setText("")
        }
        builder.setNegativeButton("그대로 작성"){ dialog, which ->

        }
        builder.show()
    }
}