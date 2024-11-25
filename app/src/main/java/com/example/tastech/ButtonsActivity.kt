package com.example.tastech

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

import com.example.tastech.HomeActivity
import com.example.tastech.ShipmentsActivity
import com.example.tastech.ChatActivity
import com.example.tastech.SettingsActivity

class ButtonsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttons)

        val homeButton: Button = findViewById(R.id.homeButton)
        val shipmentsButton: Button = findViewById(R.id.shipmentsButton)
        val chatButton: Button = findViewById(R.id.chatButton)
        val settingsButton: Button = findViewById(R.id.settingsButton)

        homeButton.setOnClickListener {
            // Navigate to home activity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        shipmentsButton.setOnClickListener {
            // Navigate to shipments activity
            val intent = Intent(this, ShipmentsActivity::class.java)
            startActivity(intent)
        }

        chatButton.setOnClickListener {
            // Navigate to chat activity
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }

        settingsButton.setOnClickListener {
            // Navigate to settings activity
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}