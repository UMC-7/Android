package com.example.umc7th_study

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.umc7th_study.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {
    lateinit var binding: ActivityMemoBinding
    private var memoContent: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // ViewBinding 초기화
        binding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.memoNextBtnTv.setOnClickListener {
            val intent = Intent(this, ContentActivity::class.java)
            intent.putExtra("memoContent", binding.memoContentEt.text.toString())
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        memoContent?.let {
            binding.memoContentEt.setText(it)
        }
    }

    override fun onPause() {
        super.onPause()
        memoContent = binding.memoContentEt.text.toString()
    }

    override fun onRestart() {
        super.onRestart()
        AlertDialog.Builder(this)
            .setMessage("다시 작성하시겠습니까?")
            .setPositiveButton("예") { _, _ ->
                // 다시 작성하지 않겠다고 하면 저장된 메모 내용 초기화
                memoContent = null
                binding.memoContentEt.setText("")
            }
            .setNegativeButton("아니오", null)
            .show()
    }
}