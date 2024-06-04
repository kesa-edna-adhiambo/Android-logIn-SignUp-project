package com.akirachix.mentorconnect

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.akirachix.mentorconnect.databinding.ActivityLogInBinding
import com.akirachix.mentorconnect.databinding.ActivityMainBinding

class LogIn : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.etSignUp.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.idLogin.setOnClickListener {
            validateLogin()
        }

    }

    fun validateLogin() {
        var formError = false

        clearErrors()

        val userName = binding.etUserName.text.toString()
        if (userName.isBlank()) {
            formError = true
            binding.tilUserName.error = "User name is required"
        }

        val password = binding.etPassword.text.toString()
        if (password.isBlank()){
            formError = true
            binding.tilPassword.error = "Put password"
        }

    }

    fun clearErrors() {
        binding.tilUserName.error = null
        binding.tilPassword.error = null

    }
}
