package com.example.tastech

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Find the TextView for signing in
        val tvGoToSignIn: TextView = findViewById(R.id.tvGoToSignIn)

        // Set an OnClickListener to navigate back to Sign In page
        tvGoToSignIn.setOnClickListener {
            // Create an Intent to start the SignInActivity
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)

            // Optionally, finish the current activity to remove it from the back stack
            finish()
        }
    }
}
