package com.example.tastech

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TermsConditionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Creating a TextView programmatically
        val textView = TextView(this)
        textView.text = """
           Terms and Conditions for FastTrack Application

          Last Updated: 21/09/2024

          Welcome to the FastTrack Application. By using our App, you agree to comply with and be bound by the following terms and conditions. Please read these terms carefully before using the App.

          1. Acceptance of Terms

          By accessing and using the FastTrack App, you acknowledge that you have read, understood, and agree to be bound by these Terms and Conditions and our Privacy Policy.

          2. Eligibility

          You must be at least 13 years old to use this App. By using the App, you represent and warrant that you meet this age requirement.

          3. User Accounts

          	•	To access certain features of the App, you may be required to create an account. You agree to provide accurate, current, and complete information during the registration process.
          	•	You are responsible for maintaining the confidentiality of your account information, including your password, and for all activities that occur under your account.
          	•	You agree to notify us immediately of any unauthorized use of your account or any other breach of security.

          4. Use of the App

          You agree to use the FastTrack App only for lawful purposes and in accordance with these Terms. You agree not to use the App:

          	•	In any way that violates any applicable federal, state, local, or international law or regulation.
          	•	To engage in any conduct that restricts or inhibits anyone’s use or enjoyment of the App, or which, as determined by us, may harm FastTrack or users of the App or expose them to liability.

          5. Intellectual Property

          All content, features, and functionality on the App, including but not limited to text, graphics, logos, icons, images, and software, are the exclusive property of FastTrack or its licensors and are protected by copyright, trademark, and other intellectual property laws.

          6. User Content

          	•	You are solely responsible for any content you submit or transmit through the App. You grant FastTrack a non-exclusive, royalty-free, perpetual, and worldwide license to use, reproduce, modify, publish, and distribute such content in any medium.
          	•	You agree not to submit any content that is unlawful, defamatory, obscene, or otherwise objectionable.

          7. Third-Party Links

          The App may contain links to third-party websites or services that are not owned or controlled by FastTrack. We have no control over, and assume no responsibility for, the content, privacy policies, or practices of any third-party websites or services.

          8. Disclaimers

          	•	The FastTrack App is provided on an “as-is” and “as-available” basis. We make no representations or warranties of any kind, express or implied, regarding the App or the information contained therein.
          	•	We do not warrant that the App will be uninterrupted, secure, or free of errors or viruses.

          9. Limitation of Liability

          To the fullest extent permitted by law, FastTrack shall not be liable for any indirect, incidental, special, consequential, or punitive damages arising from or related to your use of the App.

          10. Indemnification

          You agree to indemnify, defend, and hold harmless FastTrack and its affiliates, licensors, and service providers from any claims, damages, liabilities, losses, or expenses, including reasonable attorneys’ fees, arising out of your use of the App or violation of these Terms.

          11. Changes to Terms

          We reserve the right to modify these Terms at any time. We will notify you of any changes by posting the new Terms on the App. Your continued use of the App after such changes constitutes your acceptance of the new Terms.

          12. Governing Law

          These Terms shall be governed by and construed in accordance with the laws of South Africa, without regard to its conflict of law provisions.

          13. Contact Information

          For any questions about these Terms, please contact us at: 0782444441
        """.trimIndent()

        textView.textSize = 16f
        textView.setPadding(16, 16, 16, 16)

        // Setting the TextView as the activity's content view
        setContentView(textView)
    }
}