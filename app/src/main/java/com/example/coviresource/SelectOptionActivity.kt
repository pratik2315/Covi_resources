package com.example.coviresource

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coviresource.databinding.ActivitySelectOptionBinding

class SelectOptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectOptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CoviResource)
        binding = ActivitySelectOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDonate.setOnClickListener {
            startActivity(Intent(this, SelectItemActivity::class.java))
        }
    }
}