package com.apeman.homeassistant.domain.model

import com.google.gson.annotations.SerializedName

data class BlynkContactSensorResponse (
    @SerializedName("V2")
    val firstDevice: Int,
    @SerializedName("V3")
    val secondDevice: Int
)