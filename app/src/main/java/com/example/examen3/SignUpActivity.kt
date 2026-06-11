package com.example.examen3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.examen3.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)

        binding.btnSignUp.setOnClickListener {

            val username = binding.ttSignUpName.text.toString()
            val password = binding.ttSignUpPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()) {

                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()

            } else {

                val success = databaseHelper.insertPlayer(username, password)

                if (success) {

                    Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show()
                    finish()

                } else {

                    Toast.makeText(this, "Error al registrar", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}