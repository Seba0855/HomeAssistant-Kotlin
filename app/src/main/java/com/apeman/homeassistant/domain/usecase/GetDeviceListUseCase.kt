package com.apeman.homeassistant.domain.usecase

import com.apeman.homeassistant.repository.device.MockDeviceRepository

class GetDeviceListUseCase {
    private val repository = MockDeviceRepository()

    operator fun invoke() = repository.getDevices()
}