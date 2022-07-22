package com.apeman.homeassistant.domain.model

data class Device (
    val name: String,
    val room: String,
    val virtualPin: String,
    val value: String,
    val separatorColor: Int
)