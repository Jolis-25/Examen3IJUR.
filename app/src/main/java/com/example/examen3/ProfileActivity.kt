package com.example.examen3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examen3.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val prefs = getSharedPreferences("player_data", MODE_PRIVATE)

        val lastConnection = prefs.getString("last_connection", "Primera conexión")

        binding.tvwLastConnection.text = "Última conexión: $lastConnection"
    }
}