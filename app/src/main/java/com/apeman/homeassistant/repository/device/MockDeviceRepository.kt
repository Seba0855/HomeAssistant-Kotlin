package com.apeman.homeassistant.repository.device

import com.apeman.homeassistant.R
import com.apeman.homeassistant.domain.model.Device

class MockDeviceRepository : DeviceRepository {
    override fun getDevices(): List<Device> = listOf(
        Device(
            "Czujnik temperatury",
            "Salon",
            "V0",
            "Loading...",
            R.color.orange
        )
    )
}