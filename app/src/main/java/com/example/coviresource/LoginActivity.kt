package com.example.coviresource

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.coviresource.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CoviResource)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val auth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener {
            binding.btnLogin.isEnabled = false
            val userEmail = binding.userNameLogin.text.toString()
            val userPass = binding.userPassLogin.text.toString()
            if (userEmail.isBlank()) {
                binding.userNameLogin.error = "please enter email"
                binding.btnLogin.isEnabled = true
                return@setOnClickListener
            }
            if (userPass.isBlank()) {
                binding.userPassLogin.error = "please enter password"
                binding.btnLogin.isEnabled = true
                return@setOnClickListener
            }
            if (userPass.length < 6) {
                binding.userPassLogin.error = "password length too short!"
                binding.btnLogin.isEnabled = true
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(userEmail, userPass).addOnCompleteListener { task ->
                binding.btnLogin.isEnabled = true
                if (task.isSuccessful) {
                    startActivity(Intent(this, SelectOptionActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.admin.setOnClickListener {
            startActivity(Intent(this, SelectItemActivity::class.java))
        }
        startRegisterActivity()
    }

    private fun startRegisterActivity(){
        binding.loginHere.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}