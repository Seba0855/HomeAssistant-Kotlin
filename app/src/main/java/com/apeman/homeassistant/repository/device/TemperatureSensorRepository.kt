package com.apeman.homeassistant.repository.device

import com.apeman.homeassistant.domain.model.TemperatureReadings

interface TemperatureSensorRepository {
    suspend fun getTemperature(): String?
    suspend fun getHumidity(): String
}