package com.example.tastech

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class SettingsActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Initialize SharedPreferences to store dark mode state
        sharedPreferences = getSharedPreferences("app_preferences", MODE_PRIVATE)

        // Initialize buttons and switches
        val editProfileButton: Button = findViewById(R.id.btn_edit_profile)
        val changePasswordButton: Button = findViewById(R.id.btn_change_password)
        val darkModeSwitch: Switch = findViewById(R.id.switch_dark_mode)
        val notificationsSwitch: Switch = findViewById(R.id.switch_notifications)
        val privacyPolicyButton: Button = findViewById(R.id.btn_privacy_policy)
        val termsConditionsButton: Button = findViewById(R.id.btn_terms_conditions)
        val aboutUsButton: Button = findViewById(R.id.btn_about_us)

        // Disable Edit Profile and Change Password buttons
        editProfileButton.isEnabled = false
        changePasswordButton.isEnabled = false

        // Optional: Display a toast when disabled buttons are clicked
        editProfileButton.setOnClickListener {
            Toast.makeText(this, "Edit Profile is not available yet.", Toast.LENGTH_SHORT).show()
        }
        changePasswordButton.setOnClickListener {
            Toast.makeText(this, "Change Password is not available yet.", Toast.LENGTH_SHORT).show()
        }

        // Set the initial state of dark mode based on SharedPreferences
        val isDarkModeEnabled = sharedPreferences.getBoolean("dark_mode", false)
        darkModeSwitch.isChecked = isDarkModeEnabled
        if (isDarkModeEnabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        // Set click listeners for switches
        darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
                // Set dark mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                Toast.makeText(this, "Dark Mode Disabled", Toast.LENGTH_SHORT).show()
                // Set light mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }

            // Save the dark mode state in SharedPreferences
            sharedPreferences.edit().putBoolean("dark_mode", isChecked).apply()
        }

        notificationsSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Notifications Enabled", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Notifications Disabled", Toast.LENGTH_SHORT).show()
            }
        }

        // Navigation for Privacy Policy
        privacyPolicyButton.setOnClickListener {
            val intent = Intent(this, PrivacyPolicyActivity::class.java)
            startActivity(intent)
        }

        // Navigation for Terms and Conditions
        termsConditionsButton.setOnClickListener {
            val intent = Intent(this, TermsConditionsActivity::class.java)
            startActivity(intent)
        }

        // Navigation for About Us
        aboutUsButton.setOnClickListener {
            val intent = Intent(this, AboutUsActivity::class.java)
            startActivity(intent)
        }
    }
}