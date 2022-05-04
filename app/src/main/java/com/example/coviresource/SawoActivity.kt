package com.example.coviresource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coviresource.databinding.ActivitySawoBinding
import com.sawolabs.androidsdk.Sawo

class SawoActivity : AppCompatActivity() {

    lateinit var binding:ActivitySawoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySawoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.loginButton.setOnClickListener {
            Sawo(
                this,
                "487545eb-d216-47e9-b521-0c5e6f293158", // your api key
                "627282bd55b79ad3d7849fb921EKfvx0r8xwWj4BnX5E1eYH"  // your api key secret
            ).login(
                "email", // can be one of 'email' or 'phone_number_sms' or 'both_email_phone'
                SelectOptionActivity::class.java.name // Callback class name
            )
        }
    }
}