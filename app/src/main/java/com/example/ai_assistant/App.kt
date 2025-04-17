package com.example.ai_assistant

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ai_assistant.chat_assistant.ChatPage
import com.example.ai_assistant.chat_assistant.ChatViewModel
import com.example.ai_assistant.image_assistant.ImagePage

@Composable
fun App(modifier: Modifier = Modifier, chatViewModel: ChatViewModel) {

    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.HOME
    ) {
        composable(Screens.HOME) {
            Home(modifier= modifier, navController= navController)
        }

        composable(Screens.CHAT) {
            ChatPage(modifier = Modifier, viewModel = chatViewModel)
        }

        composable(Screens.IMAGE) {
            ImagePage(modifier = Modifier)
        }
    }
}