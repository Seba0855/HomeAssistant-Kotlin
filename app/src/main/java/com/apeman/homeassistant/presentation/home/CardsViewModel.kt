package com.apeman.homeassistant.presentation.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apeman.homeassistant.domain.usecase.GetTemperatureUseCase
import com.apeman.homeassistant.infrastructure.model.response.BlynkTemperatureResponse
import com.apeman.homeassistant.repository.device.RealTemperatureSensorRepository
import kotlinx.coroutines.*

class CardsViewModel : ViewModel() {
    val temperatureDataSet = MutableLiveData<String>()

    init {
        viewModelScope.launch {
            val getTemperature = GetTemperatureUseCase()
            withContext(Dispatchers.IO) {
                temperatureDataSet.postValue(getTemperature())
                delay(2000)
            }
            temperatureDataSet.value
        }
    }
}