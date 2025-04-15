package com.example.chatassistant

data class Message(
    val message: String,
    val role: String
)

object Role {
    const val USER = "User"
    const val MODEL = "Model"
}