package com.example.ai_assistant.image_assistant

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai_assistant.Constants.IMAGE_ART_API_KEY
import com.example.ai_assistant.chat_assistant.AppHeader
import com.example.ai_assistant.ui.theme.BgColor
import com.example.ai_assistant.ui.theme.MainColor
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

@Composable
fun ImagePage(modifier: Modifier = Modifier) {
    val text = remember { mutableStateOf("") }
    val showIndicator = remember { mutableStateOf(false) }
    val imageBitmap = remember { mutableStateOf<Bitmap?>(null) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { AppHeader(title = "Pixela") },
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
                    modifier = Modifier.padding(8.dp),
                    keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences),
                    colors = OutlinedTextFieldDefaults.colors()
                        .copy(focusedIndicatorColor = MainColor, cursorColor = MainColor)
                )

                Button(
                    onClick = {
                        showIndicator.value = true
                        callApi(text = text.value) { imageData ->
                            // Convert the byteArray to a Bitmap and update the state
                            imageBitmap.value = BitmapFactory.decodeByteArray(imageData, 0, imageData.size)
                        }
                        text.value = ""
                        //showIndicator.value = false
                    },
                    modifier = Modifier.fillMaxWidth(0.6f),
                    colors = ButtonDefaults.buttonColors(MainColor),
                    shape = RoundedCornerShape(
                        topStart = 100.dp,
                        bottomEnd = 100.dp,
                        topEnd = 0.dp,
                        bottomStart = 0.dp
                    )
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
                    if (showIndicator.value) {
                        CircularProgressIndicator(color = Color.White)
                    }
                    // Display the generated image
                    imageBitmap.value?.let { bitmap ->
                        showIndicator.value = false
                        Image(
                            bitmap = bitmap.asImageBitmap(),
                            contentDescription = "Generated Image",
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.LightGray, RoundedCornerShape(10.dp))
                                .size(250.dp),
                        )
                    }
                }
            }
        }
    }
}

fun callApi(text: String, onImageReady: (ByteArray) -> Unit) {
    val client = OkHttpClient.Builder()
        .connectTimeout(30, java.util.concurrent.TimeUnit.SECONDS)
        .readTimeout(60, java.util.concurrent.TimeUnit.SECONDS)
        .writeTimeout(30, java.util.concurrent.TimeUnit.SECONDS)
        .build()

    val apiUrl = "https://api.vyro.ai/v2/image/generations"
    val apiToken = IMAGE_ART_API_KEY // Replace with your actual token

    val requestBody = MultipartBody.Builder()
        .setType(MultipartBody.FORM)
        .addFormDataPart("prompt", text)
        .addFormDataPart("style", "realistic")
        .addFormDataPart("aspect_ratio", "1:1")
        .build()

    val request = Request.Builder()
        .url(apiUrl)
        .addHeader("Authorization", "Bearer $apiToken")
        .post(requestBody)
        .build()

    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            Log.e("API_ERROR", "Request failed: ${e.message}")
            // You could update UI state here if needed, e.g. to show error
        }

        override fun onResponse(call: Call, response: Response) {
            if (response.isSuccessful) {
                response.body?.bytes()?.let { byteArray ->
                    onImageReady(byteArray)
                } ?: Log.e("API_ERROR", "Empty image response")
            } else {
                val errorMsg = response.body?.string()
                Log.e("API_ERROR", "Server error: $errorMsg")
            }
        }
    })
}



