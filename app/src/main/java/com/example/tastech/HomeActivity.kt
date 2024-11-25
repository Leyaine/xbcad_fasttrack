package com.example.tastech

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.content.Intent

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Initialize views
        val profileIcon: ImageView = findViewById(R.id.profileIcon)
        val notificationIcon: ImageView = findViewById(R.id.notificationIcon)
        val searchBar: EditText = findViewById(R.id.searchBar)
        val currentShipmentCard: CardView = findViewById(R.id.currentShipmentCard)
        val recentShipmentCard: CardView = findViewById(R.id.recentShipmentCard)

        val currentShipmentTracking: TextView = findViewById(R.id.currentShipmentTracking)
        val currentShipmentStatus: TextView = findViewById(R.id.currentShipmentStatus)

        val recentShipmentTracking: TextView = findViewById(R.id.recentShipmentTracking)
        val recentShipmentStatus: TextView = findViewById(R.id.recentShipmentStatus)

        // Set up click listeners for interactive components
        profileIcon.setOnClickListener {
            // Handle profile icon click (e.g., navigate to profile screen)
        }

        notificationIcon.setOnClickListener {
            // Handle notification icon click (e.g., navigate to notifications screen)
        }

        currentShipmentCard.setOnClickListener {
            // Handle current shipment card click
        }

        recentShipmentCard.setOnClickListener {
            // Handle recent shipment card click
        }

        searchBar.setOnEditorActionListener { _, _, _ ->
            val query = searchBar.text.toString()
            if (query.isNotEmpty()) {
                // Handle search query submission
                searchForPackage(query)
            }
            true
        }
    }

    // Mock function to handle search functionality
    private fun searchForPackage(query: String) {
        // TODO: Add logic for searching packages
        // You might interact with a database, API, or other backend services
    }
    private fun saveTrackingNumber(trackingNumber: String) {
        val sharedPreferences = getSharedPreferences("ShipmentsData", MODE_PRIVATE)
        val trackingNumbers = sharedPreferences.getStringSet("trackingNumbers", mutableSetOf()) ?: mutableSetOf()
        trackingNumbers.add(trackingNumber)
        sharedPreferences.edit().putStringSet("trackingNumbers", trackingNumbers).apply()
    }

    private fun navigateToShipmentsActivity(trackingNumber: String) {
        val intent = Intent(this, ShipmentsActivity::class.java)
        startActivity(intent)
    }
}
