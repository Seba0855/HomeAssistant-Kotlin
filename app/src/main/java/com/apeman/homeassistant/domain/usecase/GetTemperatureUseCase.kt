package com.apeman.homeassistant.domain.usecase

import com.apeman.homeassistant.infrastructure.remote.blynk.RetrofitRemoteDataSource
import com.apeman.homeassistant.mapper.domain.HumidityMapper
import com.apeman.homeassistant.mapper.domain.QueryParamsMapper
import com.apeman.homeassistant.mapper.domain.TemperatureMapper
import com.apeman.homeassistant.repository.device.MockDeviceRepository
import com.apeman.homeassistant.repository.device.RealTemperatureSensorRepository
import com.apeman.homeassistant.repository.device.TemperatureSensorRepository

class GetTemperatureUseCase {
    private val blynkService = RetrofitRemoteDataSource()
    private val temperatureMapper = TemperatureMapper()
    private val humidityMapper = HumidityMapper()
    private val queryParamsMapper = QueryParamsMapper()
    private val mockRepository: MockDeviceRepository = MockDeviceRepository()

    private val repository: TemperatureSensorRepository = RealTemperatureSensorRepository(
        blynkService,
        temperatureMapper,
        humidityMapper,
        queryParamsMapper
    )

    suspend operator fun invoke(): String? = repository.getTemperature()
}