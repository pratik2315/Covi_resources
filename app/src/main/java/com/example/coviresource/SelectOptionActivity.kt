package com.example.coviresource

import android.content.Intent
import android.net.Uri
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

        binding.covidData.setOnClickListener {
            startActivity(Intent(this, CovidTrackerActivity::class.java))
        }

        binding.bookVaccine.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://selfregistration.cowin.gov.in/")))
        }

        binding.btnRequest.setOnClickListener {
            startActivity(Intent(this, HelplineActivity::class.java))
        }

        binding.social.setOnClickListener {
            startActivity(Intent(this, QRCodeActivity::class.java))
        }

        binding.feedSocial.setOnClickListener {
            startActivity(Intent(this, FeedActivity::class.java))
        }
    }

}