package com.apeman.homeassistant.mapper.domain

import com.apeman.homeassistant.domain.model.HumidityReadings
import com.apeman.homeassistant.infrastructure.model.response.BlynkHumidityResponse

class HumidityMapper {
    operator fun invoke(reponse: BlynkHumidityResponse) = with(reponse) {
        HumidityReadings(
            humidity = humidityResponse
        )
    }
}