package com.apeman.homeassistant.repository.device

import com.apeman.homeassistant.domain.model.TemperatureSensorReadings

interface DeviceRepository {
    suspend fun getTemperature(): TemperatureSensorReadings
}