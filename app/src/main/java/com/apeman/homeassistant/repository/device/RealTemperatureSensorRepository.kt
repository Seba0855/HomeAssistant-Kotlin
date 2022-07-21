package com.apeman.homeassistant.repository.device

import com.apeman.homeassistant.domain.model.TemperatureSensorReadings
import com.apeman.homeassistant.domain.usecase.TokenHelper
import com.apeman.homeassistant.infrastructure.model.response.BlynkTemperatureResponse
import com.apeman.homeassistant.infrastructure.remote.blynk.RetrofitRemoteDataSource
import com.apeman.homeassistant.mapper.domain.QueryParamsMapper
import retrofit2.Response

class RealDeviceRepository : DeviceRepository {
    private val blynkService = RetrofitRemoteDataSource().invoke()
    private val mapper = QueryParamsMapper()

    override suspend fun getTemperature(): TemperatureSensorReadings =
        blynkService.getTemperatureSensorData().body().temperature.map {
            mapper(it)
        }
}