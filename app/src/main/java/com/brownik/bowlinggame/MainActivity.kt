package com.brownik.bowlinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brownik.bowlinggame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        addOnClickListener()
    }

    private fun addOnClickListener() = with(binding) {
        inputButton.setOnClickListener {
            val playerCount = inputPlayer.text.toString().toInt()
            supportFragmentManager
        }
    }
}