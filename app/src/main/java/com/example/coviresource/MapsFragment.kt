package com.example.coviresource

import android.Manifest
import android.content.Intent
import android.content.Intent.getIntent
import android.content.pm.PackageManager
import android.location.Location
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.coviresource.databinding.FragmentMapsBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    var currentLocation:Location ?= null
    var fusedLocationProviderClient:FusedLocationProviderClient?= null
    val REQUEST_CODE = 1

    private val callback = OnMapReadyCallback { googleMap ->

        try {
            val latlng = LatLng(currentLocation!!.latitude, currentLocation!!.longitude)
            if (latlng == null) {
                Toast.makeText(requireContext(), "location access not allowed!", Toast.LENGTH_SHORT)
                    .show()
            }

            val intent = activity?.intent
            val OXY_VALUE = "Oxygen"
            val VENT_VALUE = "Vent"
            val FOOD_VALUE = "Food"
            val AMB_VALUE = "Amb"

            if (intent?.getStringExtra("Oxygen") == OXY_VALUE) {
                val markerOptions = MarkerOptions().position(latlng).title("I have the oxygen")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.oxy))

                googleMap.animateCamera(CameraUpdateFactory.newLatLng(latlng))
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 15f))
                googleMap.addMarker(markerOptions)
            }

            if (intent?.getStringExtra("Vent") == VENT_VALUE) {
                val markerOptions = MarkerOptions().position(latlng).title("I have the ventilator")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.vent))

                googleMap.animateCamera(CameraUpdateFactory.newLatLng(latlng))
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 15f))
                googleMap.addMarker(markerOptions)
            }

            if (intent?.getStringExtra("Food") == FOOD_VALUE) {
                val markerOptions = MarkerOptions().position(latlng).title("I have the food")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.food))

                googleMap.animateCamera(CameraUpdateFactory.newLatLng(latlng))
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 15f))
                googleMap.addMarker(markerOptions)
            }

            if (intent?.getStringExtra("Amb") == AMB_VALUE) {
                val markerOptions =
                    MarkerOptions().position(latlng).title("I have the ambulance services")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ambulance))

                googleMap.animateCamera(CameraUpdateFactory.newLatLng(latlng))
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 15f))
                googleMap.addMarker(markerOptions)
            }
        } catch (e:Exception){
            e.stackTrace
        }
    }

    private fun bitmapDesc(){

    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
        fetchLocation()

    }

    private fun fetchLocation() {
        if (ContextCompat.checkSelfPermission(this.requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_CODE)
            return
        }

        val task = fusedLocationProviderClient!!.lastLocation
        task.addOnSuccessListener { location ->
            currentLocation = location

            val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
            mapFragment?.getMapAsync(callback)

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        when(requestCode){
            REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    fetchLocation()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

}