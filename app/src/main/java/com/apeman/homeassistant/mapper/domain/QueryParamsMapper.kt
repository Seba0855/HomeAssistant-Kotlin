package com.apeman.homeassistant.mapper.domain

import com.apeman.homeassistant.domain.usecase.TokenHelper

class QueryParamsMapper {
    operator fun invoke(virtualPin: String): Map<String, String> = mapOf(
        "token" to TokenHelper.BLYNK_TOKEN,
        virtualPin to ""
    )
}