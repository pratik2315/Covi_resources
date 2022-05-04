package com.example.coviresource

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coviresource.databinding.ActivityHelplineBinding

class HelplineActivity : AppCompatActivity() {
    private var number:String?= ""
    private lateinit var binding: ActivityHelplineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CoviResource)
        binding = ActivityHelplineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dialNumber.setOnClickListener{
            number = binding.phoneNumber.text.toString().trim()
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +Uri.encode(number)))
            startActivity(intent)
        }

    }
}