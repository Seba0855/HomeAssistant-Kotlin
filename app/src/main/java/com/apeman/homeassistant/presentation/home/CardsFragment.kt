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
    private val viewModel: CardsViewModel by viewModels()
    private lateinit var tempIndicator: TextView
    private lateinit var name: TextView
    private lateinit var room: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_cards, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tempIndicator = view.findViewById(R.id.value_indicator)
        name = view.findViewById(R.id.name)
        room = view.findViewById(R.id.roomIndicator)

        viewModel.temperatureDataSet.observe(viewLifecycleOwner) { sensorData ->
            tempIndicator.text = sensorData
            name.text = "Czujnik temperatury"
            room.text = "Salon"
        }
    }

}