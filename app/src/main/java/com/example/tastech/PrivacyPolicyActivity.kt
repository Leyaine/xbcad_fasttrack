package com.example.tastech

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PrivacyPolicyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy_policy)

        // Find the TextView by its ID
        val privacyPolicyTextView = findViewById<TextView>(R.id.tv_privacy_policy)

        // Set the privacy policy text
        privacyPolicyTextView.text = """
            Privacy Policy

            At FastTrack, your privacy is of utmost importance to us. This privacy policy outlines the types of personal information that is collected and how it is used.

            1. Information Collection
            We collect personal information when you use our app, such as:
            - Name
            - Email address
            - Contact details
            - Location data (if enabled)
            - Device information
            - Usage data

            2. How We Use Your Information
            Your personal data is used for the following purposes:
            - To provide and improve our services.
            - To personalize your user experience.
            - To send notifications and updates related to your shipments.
            - To respond to inquiries and customer support requests.

            3. Data Sharing
            We do not sell or share your personal data with third parties unless required by law or for the provision of services (e.g., third-party service providers for delivery updates).

            4. Data Security
            We implement a variety of security measures to maintain the safety of your personal information. However, no method of transmission over the Internet is 100% secure.

            5. Cookies
            Our app may use cookies to enhance user experience. You can choose to disable cookies through your device settings.

            6. Your Rights
            You have the right to:
            - Access, update, or delete your personal data.
            - Opt out of receiving notifications or marketing communications.
            - Request information on how your data is being used.

            7. Changes to This Policy
            We may update this privacy policy periodically. We will notify you of any significant changes via the app.

            8. Contact Us
            If you have any questions or concerns about this Privacy Policy, please contact us at [email address/contact information].
        """.trimIndent()
    }
}