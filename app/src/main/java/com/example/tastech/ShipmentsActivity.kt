package com.example.tastech

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class ShipmentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shipments)

        // Initialize the dynamic list container
        val shipmentsContainer: LinearLayout = findViewById(R.id.shipmentsContainer)

        // Retrieve tracking numbers from SharedPreferences
        val sharedPreferences: SharedPreferences = getSharedPreferences("ShipmentsData", MODE_PRIVATE)
        val trackingNumbers: Set<String> = sharedPreferences.getStringSet("trackingNumbers", emptySet()) ?: emptySet()

        // Dynamically add tracking numbers to the container
        trackingNumbers.forEach { trackingNumber ->
            val cardView = layoutInflater.inflate(R.layout.tracking_card, null) as CardView
            val trackingNumberText: TextView = cardView.findViewById(R.id.trackingNumberText)
            trackingNumberText.text = trackingNumber
            shipmentsContainer.addView(cardView)
        }
    }
}