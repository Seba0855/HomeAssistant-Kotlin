package com.apeman.homeassistant.repository.device

import android.util.Log
import com.apeman.homeassistant.domain.model.TemperatureReadings
import com.apeman.homeassistant.infrastructure.remote.blynk.RetrofitRemoteDataSource
import com.apeman.homeassistant.mapper.domain.HumidityMapper
import com.apeman.homeassistant.mapper.domain.QueryParamsMapper
import com.apeman.homeassistant.mapper.domain.TemperatureMapper

class RealTemperatureSensorRepository (
    private val blynkService: RetrofitRemoteDataSource,
    private val temperatureMapper: TemperatureMapper,
    private val humidityMapper: HumidityMapper,
    private val queryMapper: QueryParamsMapper
) : TemperatureSensorRepository {

    override suspend fun getTemperature(): String? {
        val response = blynkService().getTemperatureSensorData(
            queryMapper(
                virtualPin1 = "V0",
                virtualPin2 = "V1"
            )
        )

        if (response.isSuccessful) {
            return temperatureMapper(response.body()).temperature
        }

        Log.e("TemperatureSensorRepository error", response.message())
        return "Error"
    }

    override suspend fun getHumidity(): String {
        TODO("Not yet implemented")
    }
}