package com.example.ai_assistant

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ai_assistant.ui.theme.BgColor
import com.example.ai_assistant.ui.theme.MainColor

@Composable
fun Home(modifier: Modifier = Modifier, navController: NavHostController) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
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
                verticalArrangement = Arrangement.spacedBy(50.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LaunchAnimatedButton {
                    Button(
                        onClick = { navController.navigate(Screens.CHAT) },
                        modifier = it
                            .clip(CircleShape)
                            .size(150.dp),
                        colors = ButtonDefaults.outlinedButtonColors(MainColor),
                        shape = RoundedCornerShape(
                            topStart = 0.dp,
                            bottomEnd = 0.dp,
                            topEnd = 100.dp,
                            bottomStart = 100.dp
                        )
                    ) {
                        Text(text = "Jarvis", fontSize = 30.sp, color = BgColor)
                    }
                }

                LaunchAnimatedButton {
                    Button(
                        onClick = { navController.navigate(Screens.IMAGE) },
                        modifier = it
                            .clip(CircleShape)
                            .size(150.dp),
                        colors = ButtonDefaults.outlinedButtonColors(MainColor),
                        shape = RoundedCornerShape(
                            topStart = 100.dp,
                            bottomEnd = 100.dp,
                            topEnd = 0.dp,
                            bottomStart = 0.dp
                        )
                    ) {
                        Text(text = "Pixela", fontSize = 30.sp, color = BgColor)
                    }
                }
            }
        }
    }
}

@Composable
fun LaunchAnimatedButton(
    modifier: Modifier = Modifier,
    content: @Composable (Modifier) -> Unit
) {
    val scale = remember { Animatable(0.5f) }

    LaunchedEffect(Unit) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1000)
        )
    }

    content(modifier.scale(scale.value))
}