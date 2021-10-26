package com.sitamadex11.CovidHelp.interfaces

import com.example.coviresource.State
import retrofit2.Response

interface NetworkService {
    suspend fun getStates(): Response<State>
}