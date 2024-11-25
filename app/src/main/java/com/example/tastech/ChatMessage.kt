package com.example.tastech

data class ChatMessage(
    val text: String = "", // Default constructor to allow for Firebase deserialization
    val isSent: Boolean
)
