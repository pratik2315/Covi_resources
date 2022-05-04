package com.example.coviresource

import com.example.coviresource.State
import retrofit2.Response

interface NetworkService {
    suspend fun getStates(): Response<State>
}