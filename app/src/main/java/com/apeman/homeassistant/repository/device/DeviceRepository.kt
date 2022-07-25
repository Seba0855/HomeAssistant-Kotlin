package com.apeman.homeassistant.repository.device

import com.apeman.homeassistant.domain.model.Device

interface DeviceRepository {
    fun getDevices(): List<Device>
}