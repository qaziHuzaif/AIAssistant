package com.example.chatassistant

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.chatassistant.ui.theme.BgColor

@Composable
fun Home(modifier: Modifier = Modifier, navController: NavHostController) {
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        containerColor = BgColor,
        contentWindowInsets = WindowInsets.statusBars
    ) { padding ->
        Box(
            modifier = modifier
            .fillMaxSize()
            .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {navController.navigate(Screens.CHAT)}
                ) {
                    Text("Jarvis")
                }
                Button(
                    onClick = {navController.navigate(Screens.IMAGE)}
                ) {
                    Text("Dall-E")
                }
            }
        }
    }
}