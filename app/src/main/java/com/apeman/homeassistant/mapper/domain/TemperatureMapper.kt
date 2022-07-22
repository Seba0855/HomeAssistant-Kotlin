package com.apeman.homeassistant.mapper.domain

import com.apeman.homeassistant.domain.model.TemperatureReadings
import com.apeman.homeassistant.domain.model.TemperatureSensorReadings
import com.apeman.homeassistant.infrastructure.model.response.BlynkTemperatureResponse
import com.apeman.homeassistant.infrastructure.model.response.BlynkTemperatureSensorResponse

class TemperatureMapper {
    operator fun invoke(response: BlynkTemperatureSensorResponse?) = with(response) {
        TemperatureSensorReadings(
            temperature = this?.temperatureResponse,
            humidity = this?.temperatureResponse
        )
    }
}