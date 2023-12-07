package com.example.advancedtask.animation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.advancedtask.MainActivity
import com.example.advancedtask.R
import com.example.advancedtask.databinding.ActivityAnimationBinding

class Animation : AppCompatActivity() {

    private lateinit var binding : ActivityAnimationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAnimation.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}