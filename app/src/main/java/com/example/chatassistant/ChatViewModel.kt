package com.example.chatassistant

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatassistant.Constants.GEMINI_API_KEY
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ChatViewModel: ViewModel() {

    val messageList by lazy { mutableStateListOf<Message>() }

    private val generativeModel: GenerativeModel = GenerativeModel(
        modelName = "gemini-2.0-flash",
        apiKey = GEMINI_API_KEY
    )

    fun sendMessage(message: String) {
        viewModelScope.launch {

            messageList.add(Message("When ever any on asks your reply as MY name is Jarvis an AI chat assistant.", Role.USER))
            val chat = generativeModel.startChat(
                history = messageList.map {
                    content(it.role){ text(it.message) }
                }.toList()
            )
            messageList.removeAt(messageList.lastIndex)

            messageList.add(Message(message, Role.USER))
            messageList.add(Message("Typing....", Role.MODEL))

            val response = chat.sendMessage(message)
            messageList.removeAt(messageList.lastIndex)
            messageList.add(Message(response.text.toString().trim(), Role.MODEL))
        }
    }
}