package com.example.week5

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.week5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var noteText: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 저장 버튼 구현
        binding.saveBtn.setOnClickListener {
            val intent = Intent(this, ViewActivity::class.java)
            intent.putExtra("text", binding.writeTv.text.toString())
            startActivity(intent)
        }
    }

    // 작성 중인 메모 내용을 전역 변수에 저장
    override fun onPause() {
        super.onPause()
        noteText = binding.writeTv.text.toString()
    }

    // 저장된 메모 내용을 EditText에 복원
    override fun onResume() {
        super.onResume()
        if (!noteText.isNullOrEmpty()) {
            binding.writeTv.setText(noteText)
        }
    }

    // 다이얼로그를 통해 메모를 계속 작성할지 여부 확인
    override fun onRestart() {
        super.onRestart()
        val builder = AlertDialog.Builder(this)
        builder.setTitle("확인")
        builder.setMessage("메모를 이어서 작성하시겠습니까?")
        builder.setPositiveButton("예") { dialog, which ->
            // 아무것도 하지 않고 계속 작성
        }
        builder.setNegativeButton("아니오") { dialog, which ->
            noteText = ""
            binding.writeTv.setText("") // EditText의 내용도 비우기
            binding.writeTv.hint = binding.writeTv.hint // XML에서 설정된 Hint 가져오기
        }
        builder.show()
    }
}