package com.apeman.homeassistant.infrastructure.remote.blynk

import com.apeman.homeassistant.domain.usecase.TokenHelper
import com.apeman.homeassistant.repository.device.BlynkAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitRemoteDataSource {
    operator fun invoke(): BlynkAPI = run {
        val retrofitBuilder: Retrofit = Retrofit.Builder()
            .baseUrl(TokenHelper.BLYNK_CLOUD_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofitBuilder.create(BlynkAPI::class.java)
    }
}