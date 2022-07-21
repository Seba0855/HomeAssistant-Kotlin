package com.apeman.homeassistant.presentation.home

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apeman.homeassistant.domain.model.BlynkTemperatureResponse
import com.apeman.homeassistant.domain.repositories.BlynkRepository
import com.apeman.homeassistant.infrastructure.repositories.RealBlynkRepository
import com.apeman.homeassistant.domain.usecase.TokenHelper
import kotlinx.coroutines.*

class CardsViewModel : ViewModel() {
    private val blynkRepository = BlynkRepository()

    val temperatureDataSet = MutableLiveData<BlynkTemperatureResponse>()

    init {
        viewModelScope.launch {
            val response = blynkRepository.getTemperature()
            withContext(Dispatchers.IO) {
                if (response.isSuccessful) {
                    temperatureDataSet.postValue(response.body())
                } else {
                    Log.e("ViewModel error", response.message())
                }
                delay(2000)
            }
            temperatureDataSet.value
        }
    }
}