package com.apeman.homeassistant.domain.usecase

import com.apeman.homeassistant.BuildConfig


class TokenHelper {
    companion object {
        const val BLYNK_CLOUD_URL: String = BuildConfig.BLYNK_CLOUD_URL
        const val BLYNK_TOKEN: String = BuildConfig.BLYNK_TOKEN
    }
}