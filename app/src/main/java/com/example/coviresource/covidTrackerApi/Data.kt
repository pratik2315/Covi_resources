package com.example.coviresource

import com.google.gson.annotations.SerializedName

class Data(
    @SerializedName("summary")
    var summary: Summery,
    var regional: List<Regional>
)