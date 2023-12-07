package com.example.advancedtask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.advancedtask.movie.MovieMainActivity
import com.example.advancedtask.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnAPI.setOnClickListener {
            val intent = Intent(this, MovieMainActivity::class.java)
            startActivity(intent)
        }
    }
}