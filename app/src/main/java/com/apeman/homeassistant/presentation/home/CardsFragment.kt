package com.apeman.homeassistant.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.apeman.homeassistant.R

class CardsFragment : Fragment() {
    private val viewModel: CardsViewModel by viewModels()
    private val cardsAdapter = CardsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_cards, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.cardList).apply {
            adapter = cardsAdapter
        }

        viewModel.deviceList.observe(viewLifecycleOwner) { deviceList ->
            cardsAdapter.setDevices(deviceList)
        }
    }

}