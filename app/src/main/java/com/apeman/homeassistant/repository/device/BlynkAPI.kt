package com.apeman.homeassistant.repository.device

import com.apeman.homeassistant.infrastructure.model.response.BlynkTemperatureResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface BlynkAPI {
    /**
     * This method allows user to retrieve data from virtual pins using GET method.
     *
     * @param token Blynk.cloud token
     * @param a as "V0" does not take any parameters, it should be always null
     * @param b as "V1" does not take any parameters, it should be always null
     */
    @GET("get")
    suspend fun getTemperatureSensorData (
        @QueryMap queryParameters: Map<String, String>
    ): Response<BlynkTemperatureResponse>

    /**
     * Allows user to get information if doors are open or closed
     * (defined by V2 virtualPin value)
     *
     * @param token Blynk.cloud token
     * @param a as "V2" does not take any parameters, it should be always null
     * @param b as "V3" does not take any parameters, it should be always null
     */
    @GET("get")
    suspend fun getContactSensorStatus(
        @Query("token") token: String,
        @Query("V3") a: String,
        @Query("V4") b: String
    )
}