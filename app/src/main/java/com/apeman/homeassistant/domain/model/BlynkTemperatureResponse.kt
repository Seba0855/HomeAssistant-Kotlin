package com.apeman.homeassistant.domain.model

import com.google.gson.annotations.SerializedName

data class BlynkTemperatureResponse(
    @SerializedName("V0")
    val temperature: String,
    @SerializedName("V1")
    val humidity: String
)
