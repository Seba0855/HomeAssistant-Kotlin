package com.apeman.homeassistant.infrastructure.model.response

import com.google.gson.annotations.SerializedName

data class BlynkTemperatureSensorResponse(
    @SerializedName("V0")
    val temperatureResponse: String?,
    @SerializedName("V1")
    val humidityResponse: String?
)
