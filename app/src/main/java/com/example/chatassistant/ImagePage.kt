package com.example.chatassistant

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatassistant.ui.theme.BgColor
import com.example.chatassistant.ui.theme.MainColor

@Composable
fun ImagePage(modifier: Modifier = Modifier) {
    val text = remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = { AppHeader(title = "Dall-E") },
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
                TextField(
                    value = text.value,
                    onValueChange = { text.value = it },
                    textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                    modifier = Modifier
                        .padding(8.dp),
                    keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences),
                    colors = OutlinedTextFieldDefaults.colors()
                        .copy(focusedIndicatorColor = MainColor, cursorColor = MainColor)
                )
                Button(
                    onClick = {
                        text.value = ""
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.6f),
                    colors = ButtonDefaults.buttonColors(MainColor),
                    shape = RoundedCornerShape(topStart = 100.dp, bottomEnd = 100.dp, topEnd = 0.dp, bottomStart = 0.dp)
                ) {
                    Text(
                        text = "Generate",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 2.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .background(Color.LightGray, RoundedCornerShape(10.dp))
                        .size(250.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Image")
                }
            }
        }
    }
}