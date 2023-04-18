package com.example.messager.data


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import com.example.messager.Screen.MessageBubble
import com.example.messager.Screen.NewMessageInput
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ChatScreen(modifier: Modifier,/*messages: List<Message>*/) {
    val messages = remember { mutableStateListOf<String>() }
    val context= LocalContext.current
    val firebaseManager = FirebaseManager(context)

    // Autenticación del usuario
    val user = FirebaseAuth.getInstance().currentUser
    val sender = user?.uid ?: ""
    // Envío de un mensaje
    val recipient = "1234567890" // ID del destinatario
    Column(
             //  modifier=modifier,
        verticalArrangement = Arrangement.Bottom)

    {
        LazyColumn {
            items(messages.size) { index ->
                MessageBubble(
                    message = messages[index],
                    sentByMe = index % 2 == 0
                )
            }
        }
        NewMessageInput(onMessageSent = { message ->
            messages.add(message)

        })
    }
}

/*@Composable
fun MessageItem(message: Message) {
    Row {
        Text("${message.sender}: ${message.text}")
        Text("${message.timestamp}")
    }
}
*/
