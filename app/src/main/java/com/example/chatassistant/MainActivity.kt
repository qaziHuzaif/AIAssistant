package com.example.chatassistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import com.example.chatassistant.ui.theme.ChatAssistantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val chatViewModel = ChatViewModel()
        setContent {
            ChatAssistantTheme(darkTheme = false) {
                App(modifier = Modifier, chatViewModel = chatViewModel)
            }
        }
    }
}