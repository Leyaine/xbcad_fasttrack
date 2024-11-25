package com.example.tastech

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val emailInput: EditText = findViewById(R.id.etEmail)
        val submitButton: Button = findViewById(R.id.btnSubmit)
        val backToSignIn: TextView = findViewById(R.id.tvBackToSignIn)


        // Navigate back to SignInActivity
        backToSignIn.setOnClickListener {
            finish() // This will close the current activity and go back to the previous one
        }
    }
}
