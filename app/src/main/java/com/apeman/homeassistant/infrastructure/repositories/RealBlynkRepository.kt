package com.apeman.homeassistant.infrastructure.repositories

import com.apeman.homeassistant.domain.usecase.TokenHelper
import com.apeman.homeassistant.infrastructure.remote.blynk.RetrofitBlynkDataSource
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RealBlynkRepository {
    companion object {
        fun create() : RetrofitBlynkDataSource {
            val retrofitBuilder: Retrofit = Retrofit.Builder()
                .baseUrl(TokenHelper.BLYNK_CLOUD_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofitBuilder.create(RetrofitBlynkDataSource::class.java)
        }
    }
}