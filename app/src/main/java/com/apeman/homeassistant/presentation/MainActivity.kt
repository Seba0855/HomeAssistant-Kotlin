package com.apeman.homeassistant.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.TooltipCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.apeman.homeassistant.R
import com.apeman.homeassistant.presentation.home.CardsAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        // Setting up the bottom navigation view
        findViewById<BottomNavigationView>(R.id.bottom_navigation_view).apply {
            setupWithNavController(navController)

            // Disabling navigation tooltips on long click
            for (i in 0 until menu.size()) {
                val navigationItem = menu.getItem(i)
                TooltipCompat.setTooltipText(findViewById(navigationItem.itemId), null)
            }
        }

        // Displaying fragment name in toast
        navController.addOnDestinationChangedListener { _, destination, _ ->
            Toast.makeText(this, destination.label, Toast.LENGTH_LONG).show()
        }
    }
}