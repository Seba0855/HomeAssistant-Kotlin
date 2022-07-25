package com.apeman.homeassistant.presentation.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apeman.homeassistant.R
import com.apeman.homeassistant.domain.model.Device

class CardsAdapter() : RecyclerView.Adapter<CardItemViewHolder>() {

    private var cards = emptyList<Device>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardItemViewHolder {
        val view = parent.inflateNoAttach(R.layout.grid_item)
        return CardItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardItemViewHolder, position: Int) {
        holder.bind(cards[position])
    }

    override fun getItemCount(): Int = cards.count()

    fun setDevices(devices: List<Device>) {
        cards = devices
        notifyDataSetChanged()
    }
}

class CardItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(deviceDetails: Device) = with(itemView) {
        findViewById<TextView>(R.id.roomIndicator).text = deviceDetails.room
        findViewById<TextView>(R.id.value_indicator).text = deviceDetails.value
        findViewById<TextView>(R.id.name).text = deviceDetails.name
        findViewById<View>(R.id.line).setBackgroundColor(deviceDetails.separatorColor)
    }
}

private fun ViewGroup.inflateNoAttach(res: Int): View =
    LayoutInflater.from(context).inflate(res, this, false)