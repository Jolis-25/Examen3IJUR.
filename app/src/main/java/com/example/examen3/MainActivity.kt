package com.example.examen3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.btnLogin.setOnClickListener {

            val username = binding.ttName.text.toString()
            val password = binding.ttPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()) {

                Toast.makeText(
                    this,
                    "Completa todos los campos",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                val exists = databaseHelper.checkUser(username, password)

                if (exists) {

                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)

                } else {

                    Toast.makeText(
                        this,
                        "Credenciales incorrectas",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }


        binding.btnRegister.setOnClickListener {

            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}