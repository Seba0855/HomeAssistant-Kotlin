package com.apeman.homeassistant.repository.sensor

interface TemperatureSensorRepository {
    suspend fun getTemperature(): String?
    suspend fun getHumidity(): String
}