package com.apeman.homeassistant.domain.repositories

import com.apeman.homeassistant.domain.usecase.TokenHelper
import com.apeman.homeassistant.infrastructure.repositories.RealBlynkRepository

class BlynkRepository {
    private val token = TokenHelper.BLYNK_TOKEN
    private val blynkService = RealBlynkRepository.create()

    private fun setQueryParametersFor(): Map<String, String> = mapOf(
        "token" to token,
        "V0" to "",
        "V1" to ""
    )

    suspend fun getTemperature() = blynkService.getTemperatureSensorData(setQueryParametersFor())
}