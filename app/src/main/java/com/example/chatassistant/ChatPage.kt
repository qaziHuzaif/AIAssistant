package com.example.chatassistant

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import com.example.chatassistant.ui.theme.MainColor

//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.Send
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.IconButtonDefaults
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.OutlinedTextFieldDefaults
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.MutableState
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardCapitalization
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.chatassistant.ui.theme.MainColor
//
//@Composable
//fun ChatPage(modifier: Modifier = Modifier) {
//    val text = remember { mutableStateOf("") }
//
//    Scaffold(
//        topBar = { AppHeader() },
//    ) { innerpadding ->
//        Column(modifier = modifier.padding(innerpadding)) {
//
//            ChatList()
//            ChatInput(text = text)
//        }
//    }
//}
//
//@Composable
//fun ChatList() {
//    Column(
//        modifier = Modifier
//            .weight(1f),
//        state = listState
//    ) {
//        items(messages) {
//
//        }
//    }
//}
//
//@Composable
//fun ChatInput(text: MutableState<String>) {
//    Row {
//        OutlinedTextField(
//            value = text.value,
//            onValueChange = { text.value = it },
//            textStyle = TextStyle.Default.copy(fontSize = 16.sp),
//            modifier = Modifier
//                .weight(1f)
//                .padding(8.dp),
//            trailingIcon = {
//                IconButton(
//                    onClick = {
//
//                    },
//                    enabled = text.value.isNotBlank(),
//                    colors = IconButtonDefaults.iconButtonColors().copy(contentColor = MainColor)
//                ) {
//                    Icon(
//                        imageVector = Icons.AutoMirrored.Filled.Send,
//                        contentDescription = "Send",
//                    )
//                }
//            },
//            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences),
//            colors = OutlinedTextFieldDefaults.colors()
//                .copy(focusedIndicatorColor = MainColor, cursorColor = MainColor)
//        )
//    }
//}
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AppHeader() {
//    TopAppBar(
//        title = {
//            Text(
//                text = "Assistant",
//                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.White,
//                modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
//            )
//        },
//        colors = TopAppBarDefaults.topAppBarColors(MainColor)
//    )
//}


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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

@Composable
fun ChatPage(modifier: Modifier = Modifier, viewModel: ChatViewModel) {
    val text = remember { mutableStateOf("") }
    val messageList: List<Message> = viewModel.messageList

    Scaffold(
        topBar = { AppHeader(title = "Jarvis") },
        modifier = modifier
            .fillMaxSize(),
        containerColor = BgColor,
        contentWindowInsets = WindowInsets.statusBars
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, bottom = 16.dp)
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f),
                reverseLayout = true
            ) {
                items(messageList.reversed()) {
                    ChatMessageItem(
                        message = it
                    )
                }
            }

            Row {
                OutlinedTextField(
                    value = text.value,
                    onValueChange = { text.value = it },
                    textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                viewModel.sendMessage(text.value)
                                text.value = ""
                            },
                            enabled = text.value.isNotBlank(),
                            colors = IconButtonDefaults.iconButtonColors()
                                .copy(contentColor = MainColor)
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.Send,
                                contentDescription = "Send",
                            )
                        }
                    },
                    keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences),
                    colors = OutlinedTextFieldDefaults.colors()
                        .copy(focusedIndicatorColor = MainColor, cursorColor = MainColor)
                )
            }
        }
    }
}

@Composable
fun ChatMessageItem(message: Message) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = if (message.role == Role.USER) Alignment.End else Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = if (message.role == Role.USER) MainColor else Color.DarkGray,
                    shape = if (message.role == Role.USER) RoundedCornerShape(20.dp).copy(
                        bottomEnd = CornerSize(0.dp)
                    ) else RoundedCornerShape(20.dp).copy(
                    bottomStart = CornerSize(0.dp)
                     )
                )
                .widthIn(max = 250.dp)
                .padding(12.dp)
        ) {
            Text(
                text = message.message,
                fontSize = 16.sp,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = message.role,
            fontSize = 12.sp,
            color = Color.DarkGray
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHeader(title: String) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(MainColor)
    )
}