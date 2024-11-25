package com.example.tastech

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import androidx.activity.result.ActivityResultLauncher



class ChatActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private lateinit var chatAdapter: ChatAdapter
    private val chatMessages = mutableListOf<ChatMessage>()

    private val requestCodePickFile = 1 // Renamed to follow conventions

    private lateinit var filePickerLauncher: ActivityResultLauncher<Intent> // Added ActivityResultLauncher

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        // Initialize Firebase Database reference
        database = FirebaseDatabase.getInstance().getReference("chats")

        // Initialize RecyclerView and its adapter
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMessages)
        recyclerView.layoutManager = LinearLayoutManager(this)
        chatAdapter = ChatAdapter(chatMessages)
        recyclerView.adapter = chatAdapter

        // Initialize EditText and Buttons
        val editTextMessage = findViewById<EditText>(R.id.editTextMessage)
        val buttonSend = findViewById<ImageButton>(R.id.buttonSend)
        val buttonAttach = findViewById<ImageButton>(R.id.buttonAttach)

        // Request permissions for reading external storage
        requestStoragePermissions()

        // Initialize file picker launcher
        filePickerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                result.data?.data?.let { uri ->
                    uploadDocument(uri)
                }
            }
        }

        // Set up Bottom Navigation

        // Load existing messages from Firebase
        loadMessages()

        // Set click listener for send button
        buttonSend.setOnClickListener {
            val messageText = editTextMessage.text.toString().trim()
            if (messageText.isNotEmpty()) {
                sendMessage(messageText)
                editTextMessage.text.clear()
            }
        }

        // Set click listener for attach button
        buttonAttach.setOnClickListener {
            openFilePicker()
        }
    }

    // Request permissions for external storage
    private fun requestStoragePermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), requestCodePickFile)
        }
    }

    // Open file picker
    private fun openFilePicker() {
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            type = "*/*" // Allow all file types
            addCategory(Intent.CATEGORY_OPENABLE)
        }
        filePickerLauncher.launch(Intent.createChooser(intent, "Select Document"))
    }

    // Upload the selected document (placeholder implementation)
    private fun uploadDocument(uri: Uri) {
        // Implement your document upload logic here
        Toast.makeText(this, "Document selected: $uri", Toast.LENGTH_SHORT).show()
        // Example: Upload to Firebase Storage or handle it as needed
    }

    // Load messages from Firebase
    private fun loadMessages() {
        database.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val message = snapshot.getValue(ChatMessage::class.java)
                message?.let {
                    chatMessages.add(it)
                    chatAdapter.notifyItemInserted(chatMessages.size - 1)
                }
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                // Handle changes if needed
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                // Handle removals if needed
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                // Handle moves if needed
            }

            override fun onCancelled(error: DatabaseError) {
                // Log error if needed
            }
        })
    }

    // Send a message to Firebase
    private fun sendMessage(messageText: String) {
        val message = ChatMessage(text = messageText, isSent = true) // Set isSent to true for sent messages
        database.push().setValue(message)
    }
}
