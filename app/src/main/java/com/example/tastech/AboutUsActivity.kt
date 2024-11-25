package com.example.tastech

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.TextViewCompat
import com.example.tastech.R

class AboutUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Dynamically create a TextView for the About Us content
        val aboutUsTextView = TextView(this).apply {
            text = """
                Welcome to FastTrack!
                
                At FastTrack, we believe that tracking your shipments should be simple, efficient, and transparent. Our mission is to provide users with a seamless experience in managing their deliveries, ensuring that you always know the status of your shipments from start to finish.

                Who We Are
                
                FastTrack is a dedicated team of logistics and technology enthusiasts committed to enhancing the way individuals and businesses track their orders. We understand the importance of timely deliveries and the peace of mind that comes with knowing where your package is at any given moment.

                What We Offer
                
                Our application is designed to provide you with real-time updates on your shipments, making it easier than ever to manage your deliveries. With features such as live tracking, notifications, and a user-friendly interface, FastTrack ensures that you are always informed and in control.

                Our Vision
                
                We envision a world where tracking shipments is hassle-free and accessible to everyone. By leveraging the latest technology and data analytics, we aim to revolutionize the delivery process, making it faster and more reliable.

                Our Commitment
                
                At FastTrack, we are committed to customer satisfaction. We value your feedback and continuously strive to improve our services. Our customer support team is always ready to assist you with any inquiries or concerns you may have.

                Join Us on This Journey
                
                Whether you are a frequent shopper, a business owner, or someone who simply wants to stay informed about their deliveries, FastTrack is here to help. Download our app today and experience the future of shipment tracking!

                Thank you for choosing FastTrack!
            """.trimIndent()
            TextViewCompat.setTextAppearance(this, android.R.style.TextAppearance_Medium)
            setPadding(16, 16, 16, 16)
        }

        // Set the content view to the dynamically created TextView
        setContentView(aboutUsTextView)
    }
}