package com.apeman.homeassistant.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apeman.homeassistant.domain.model.Device
import com.apeman.homeassistant.domain.usecase.GetDeviceListUseCase
import com.apeman.homeassistant.domain.usecase.GetTemperatureUseCase
import kotlinx.coroutines.*

class CardsViewModel : ViewModel() {

    private val temperatureDataSet = MutableLiveData<String>()
    val deviceList = MutableLiveData<List<Device>>()
    private val getTemperature = GetTemperatureUseCase()
    private val getDevices = GetDeviceListUseCase()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                with(getDevices()) {
                    map { device ->
                        device.value = getTemperature() ?: "--.-"
                    }
                    deviceList.postValue(this)
                }

                delay(2000)
            }
            temperatureDataSet.value
        }
    }
}