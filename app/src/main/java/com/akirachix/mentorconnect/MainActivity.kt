package com.akirachix.mentorconnect

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.akirachix.mentorconnect.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etLogin.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }

        binding.etRegister.setOnClickListener { validateRegistration() }

    }

    fun validateRegistration() {
        var formError = false

        clearErrors()

        val firstName = binding.etFirstName.text.toString()
        if (firstName.isBlank()) {
            formError = true
            binding.tilFirstName.error = "First name is required"
        }

        val lastName = binding.etLastName.text.toString()
        if (lastName.isBlank()) {
            formError = true
            binding.tilLastName.error = "Last name is required"
        }

        val codeHiveId = binding.etCodeHiveId.text.toString()
        if (codeHiveId.isBlank()) {
            formError = true
            binding.tilCodeHiveId.error = "CodeHive Id is required"

        }

        val email = binding.etEmail.text.toString()
        if (email.isBlank()) {
            formError = true
            binding.tilEmail.error = "Email required"
        }

        val userName = binding.etUserName.text.toString()
        if (userName.isBlank()) {
            formError = true
            binding.tilUserName.error = "User name is required"
        }

        val password = binding.etPassword.text.toString()
        if (password.isBlank()) {
            formError = true
            binding.tilPassword.error = "Password required"
        }

        val confirmPassword = binding.etConfirmPassword.text.toString()
        if (confirmPassword.isBlank()) {
            formError = true
            binding.tilConfirmPassword.error = "Password confirmation required"
        }

        if (password != confirmPassword) {

            formError = true
            binding.tilConfirmPassword.error = "Incorrect password"

        }

        if (!formError) {
            var registration2 = Registration(
                firstName = firstName,
                lastName = lastName,
                codeHiveId = codeHiveId,
                email = email,
                userName = userName,
                password = password,
                confirmPassword = confirmPassword

            )

            val registration = Registration(firstName, lastName, codeHiveId, email, userName, password, confirmPassword)
        }
    }

        fun clearErrors() {
            binding.tilFirstName.error = null
            binding.tilLastName.error = null
            binding.tilCodeHiveId.error = null
            binding.tilEmail.error = null
            binding.tilUserName.error = null
            binding.tilPassword.error = null
            binding.tilConfirmPassword.error = null

        }
    }

