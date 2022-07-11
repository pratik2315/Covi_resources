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
                "f4374e51-52d0-4b64-8797-106293ddb147", // your api key
                "62734f49fdd1e393cf83703bmQvbyM6S7lhyQrK9oBMlR7VN"  // your api key secret
            ).login(
                "email", // can be one of 'email' or 'phone_number_sms' or 'both_email_phone'
                SelectOptionActivity::class.java.name // Callback class name
            )
        }
    }
}