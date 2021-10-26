package com.example.coviresource

data class State(
    val states: List<StateDetails>,
    val ttl: Int
)

data class StateDetails(
    val state_id: String,
    val state_name: String
)