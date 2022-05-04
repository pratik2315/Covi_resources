package com.example.coviresource

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @get:GET("latest")
    val covidData: Call<CovidData?>?

    companion object {
        const val BASE_URL = "https://api.rootnet.in/covid19-in/stats/"
    }

}