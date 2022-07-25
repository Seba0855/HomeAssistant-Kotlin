package com.apeman.homeassistant.repository.sensor

import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ContactSensorRepository {
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
        @QueryMap queryParameters: Map<String, String>
    )
}