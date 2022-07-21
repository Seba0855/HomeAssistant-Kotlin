package com.apeman.homeassistant.mapper.domain

import com.apeman.homeassistant.domain.model.TemperatureReadings
import com.apeman.homeassistant.infrastructure.model.response.BlynkTemperatureResponse

class TemperatureMapper {
    operator fun invoke(response: BlynkTemperatureResponse?) = with(response) {
        TemperatureReadings(
            temperature = this?.temperatureResponse
        )
    }
}