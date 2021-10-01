package com.example.coviresource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.coviresource.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val auth = FirebaseAuth.getInstance()

        binding.btnSignUp.setOnClickListener {
            binding.btnSignUp.isEnabled = false
            val userEmail = binding.etRegEmail.text.toString()
            val userPassword = binding.etRegPassword.text.toString()

            if (userEmail.isBlank() || userPassword.isBlank()) {
                Toast.makeText(this, "Input fields Cannot be Empty!", Toast.LENGTH_SHORT).show()
                binding.btnSignUp.isEnabled = true
                return@setOnClickListener
            }
            if (userPassword.length < 6){
                Toast.makeText(this, "password cannot be shorter than 6 characters", Toast.LENGTH_SHORT).show()
                binding.btnSignUp.isEnabled = true
                return@setOnClickListener
            }
            auth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener { task ->
                binding.btnSignUp.isEnabled = true
                if (task.isSuccessful) {
                    Toast.makeText(this, "Register success", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}