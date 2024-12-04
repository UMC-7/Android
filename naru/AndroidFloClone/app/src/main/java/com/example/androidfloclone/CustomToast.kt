package com.example.androidfloclone

import android.content.Context
import android.view.LayoutInflater
import android.widget.Toast
import com.example.androidfloclone.databinding.ToastBinding

object CustomToast {

    fun showToast(context: Context, message: String) {
        val inflater = LayoutInflater.from(context)
        val binding = ToastBinding.inflate(inflater)

        binding.toastTv.text = message

        Toast(context).apply {
            duration = Toast.LENGTH_SHORT
            view = binding.root
            show()
        }
    }
}