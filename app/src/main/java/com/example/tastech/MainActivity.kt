package com.example.tastech

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Use the splash layout

        // Delay for 5 seconds before navigating to SignInActivity
        Handler().postDelayed({
            // Create an intent to navigate to SignInActivity
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish() // Finish the current activity so user can't go back to it
        }, 5000) // 5000 milliseconds = 5 seconds
    }
}
