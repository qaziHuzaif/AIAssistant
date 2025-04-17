package com.example.ai_assistant.chat_assistant

data class Message(
    val message: String,
    val role: String
)

object Role {
    const val USER = "User"
    const val MODEL = "Model"
}