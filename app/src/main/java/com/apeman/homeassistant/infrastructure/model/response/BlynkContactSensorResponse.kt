package com.apeman.homeassistant.infrastructure.model.response

import com.google.gson.annotations.SerializedName

data class BlynkContactSensorResponse (
    @SerializedName("V2")
    val firstDevice: Int?,
    @SerializedName("V3")
    val secondDevice: Int?
)