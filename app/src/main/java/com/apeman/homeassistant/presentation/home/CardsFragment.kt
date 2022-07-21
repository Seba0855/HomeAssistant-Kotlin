package com.apeman.homeassistant.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.apeman.homeassistant.R

class CardsFragment : Fragment() {

    companion object {
        fun newInstance() = CardsFragment()
    }

    private val viewModel: CardsViewModel by viewModels()
    private lateinit var tempIndicator: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_cards, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tempIndicator = view.findViewById(R.id.temperature_indicator)

        viewModel.temperatureDataSet.observe(viewLifecycleOwner) { sensorData ->
            tempIndicator.text = sensorData
        }
    }

}