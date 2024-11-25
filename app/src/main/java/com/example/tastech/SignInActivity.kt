package com.example.tastech

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {
    // Hardcoded credentials (For demonstration purposes only)
    private val correctUsername = "user"
    private val correctPassword = "password123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // Find the TextView for "Don't have an account? Sign Up"
        val signUpLink: TextView = findViewById(R.id.tvGoToSignUp)

        // Set click listener to navigate to SignUpActivity
        signUpLink.setOnClickListener {
            // Create an intent to navigate to SignUpActivity
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView for "Forgot password?"
        val forgotPasswordLink: TextView = findViewById(R.id.tvForgotPassword)

        // Set click listener to navigate to ForgotPasswordActivity
        forgotPasswordLink.setOnClickListener {
            // Create an intent to navigate to ForgotPasswordActivity
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        // Find the EditTexts for the username and password fields
        val usernameEditText: EditText = findViewById(R.id.etUsername)
        val passwordEditText: EditText = findViewById(R.id.etPassword)

        // Find the sign-in button
        val signInButton: Button = findViewById(R.id.btnSignIn)

        // Set click listener for the Sign In button
        signInButton.setOnClickListener {
            // Get the entered username and password
            val enteredUsername = usernameEditText.text.toString()
            val enteredPassword = passwordEditText.text.toString()

            // Perform simple validation (check if entered credentials match hardcoded ones)
            if (enteredUsername == correctUsername && enteredPassword == correctPassword) {
                // Credentials are correct, navigate to ButtonsActivity
                val intent = Intent(this, ButtonsActivity::class.java)
                startActivity(intent)

                // Optionally, finish this activity so the user can't go back to it
                finish()
            } else {
                // Show an error if credentials are incorrect (you can add a toast or error message)
                // For example:
                usernameEditText.error = "Invalid username or password"
            }
        }
    }
}