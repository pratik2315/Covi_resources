package com.example.coviresource

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.coviresource.databinding.ActivitySelectItemBinding

class SelectItemActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySelectItemBinding
    private val OXYGEN_KEY = "Oxygen"
    private val  VENTILATOR_KEY= "Vent"
    private val FOOD_KEY = "Food"
    private val AMBULANCE_KEY = "Amb"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CoviResource)
        binding = ActivitySelectItemBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ArrayAdapter.createFromResource(
                this,
                R.array.resources,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerResources.adapter = adapter
        }



        var initialSelectedPosition : Int = binding.spinnerResources.selectedItemPosition
        binding.spinnerResources.setSelection(initialSelectedPosition, false)

        binding.spinnerResources.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
            ) {
                //Toast.makeText(this@SelectItemActivity, "you selected ${parent?.getItemAtPosition(position).toString()}", Toast.LENGTH_SHORT ).show()

                if (parent?.getItemAtPosition(position) == "Oxygen 🏥"){
                    binding.btnPost.setOnClickListener {
                        var userValue = binding.resourceQty.text.toString()
                        if (userValue.isBlank()){
                            binding.resourceQty.setError("Please enter a number")
                        }
                        var intent = Intent(this@SelectItemActivity, MapsActivity::class.java)
                        intent.putExtra("Oxygen", OXYGEN_KEY)
                        startActivity(intent)
                    }
                }

                if (parent?.getItemAtPosition(position) == "Ambulance Services 🚑"){
                    binding.btnPost.setOnClickListener {
                        var intent = Intent(this@SelectItemActivity, MapsActivity::class.java)
                        intent.putExtra("Amb", AMBULANCE_KEY)
                        startActivity(intent)
                    }
                }

                if (parent?.getItemAtPosition(position) == "Ventilator ⛽"){
                    binding.btnPost.setOnClickListener {
                        var intent = Intent(this@SelectItemActivity, MapsActivity::class.java)
                        intent.putExtra("Vent", VENTILATOR_KEY)
                        startActivity(intent)
                    }
                }

                if (parent?.getItemAtPosition(position) == "Food 🍞"){
                    binding.btnPost.setOnClickListener {
                        var intent = Intent(this@SelectItemActivity, MapsActivity::class.java)
                        intent.putExtra("Food", FOOD_KEY)
                        startActivity(intent)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {


            }

        }


    }
}