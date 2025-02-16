package com.lnkov.messengerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val inputText : EditText = findViewById(R.id.inputText)
        val buttonSendMessage : Button = findViewById(R.id.buttonSendMessage)
        buttonSendMessage.setOnClickListener {
            val message : String = inputText.text.toString()
            launchNextScreen(message)
        }
    }
    fun launchNextScreen(message : String) {
        val intent = Intent(this, ReveivedMessageActivity::class.java)
        intent.putExtra("message", message)
        startActivity(intent)
    }
}