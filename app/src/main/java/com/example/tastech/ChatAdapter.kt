package com.example.tastech

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private val chatMessages: List<ChatMessage>) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_message, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val message = chatMessages[position]
        // Here you can set the visibility based on whether the message is sent or received
        if (message.isSent) {
            holder.textViewMessageSent.text = message.text
            holder.textViewMessageSent.visibility = View.VISIBLE
            holder.textViewMessageReceived.visibility = View.GONE
        } else {
            holder.textViewMessageReceived.text = message.text
            holder.textViewMessageReceived.visibility = View.VISIBLE
            holder.textViewMessageSent.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return chatMessages.size
    }

    class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewMessageSent: TextView = itemView.findViewById(R.id.textViewMessageSent)
        val textViewMessageReceived: TextView = itemView.findViewById(R.id.textViewMessageReceived)
    }
}
