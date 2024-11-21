package com.example.memo

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.memo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var savedMemo: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 버튼 클릭 리스너 설정
        binding.btnSave.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("memo", binding.editMemo.text.toString())
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        // 저장된 메모가 있으면 EditText에 설정
        if (savedMemo.isNotEmpty()) {
            binding.editMemo.setText(savedMemo)
        }
    }

    override fun onPause() {
        super.onPause()
        // 현재 작성 중인 메모 내용 저장
        savedMemo = binding.editMemo.text.toString()
    }

    override fun onRestart() {
        super.onRestart()
        AlertDialog.Builder(this)
            .setTitle("메모")
            .setMessage("메모를 다시 작성하시겠습니까?")
            .setPositiveButton("예") { _, _ ->
                // 다시 작성하기를 선택하면 입력값이랑 저장값 모두 지움
                binding.editMemo.setText("")
                savedMemo = ""
            }
            .setNegativeButton("아니오") { _, _ ->
                // 다시 작성하지 않으면 이전에 작성된 내용 유지
                binding.editMemo.setText(savedMemo)
            }
            .show()
    }
}