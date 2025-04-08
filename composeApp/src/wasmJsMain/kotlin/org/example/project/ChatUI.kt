package org.example.project

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import repository.OpenAIRepository

@Composable
fun ChatUI() {
    MaterialTheme {
        ChatScreen()
    }
}

@Composable
fun ChatScreen() {
    val coroutineScope = rememberCoroutineScope()
    var isSending by remember { mutableStateOf(false) }
    val openAIRepository = remember { OpenAIRepository() }
    var chatMessages by remember { mutableStateOf<List<Message>>(emptyList()) }
    var userMessage by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Chat messages display
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            reverseLayout = true,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(chatMessages.reversed()) { message ->
                ChatMessage(message)
            }
        }

        // User input field
        OutlinedTextField(
            value = userMessage,
            onValueChange = { userMessage = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Enter your message here") }
        )

        // Send button
        Button(
            onClick = {
                if (userMessage.isNotEmpty()) {
                    val newMessage = Message("user", userMessage)
                    chatMessages = chatMessages + newMessage
                    //main logic
                    coroutineScope.launch {
                        isSending = true
                        val responseText = openAIRepository.sendMessage(chatMessages)
                        responseText?.let {
                            val botMessage = Message("assistant", it)
                            chatMessages = chatMessages + botMessage
                        }
                        isSending = false
                    }
                    userMessage = ""
                }
            },
            modifier = Modifier.fillMaxWidth(0.3f),
            enabled = !isSending,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Send")
        }
    }
}

@Composable
fun ChatMessage(message: Message) {
    val backgroundColor = if (message.role == "user") Color.Blue else Color.Gray
    Row(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier.padding(4.dp),
            backgroundColor = backgroundColor,
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = message.content, modifier = Modifier.padding(8.dp), color = Color.White)
        }
    }
}