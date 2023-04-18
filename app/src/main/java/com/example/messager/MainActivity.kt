package com.example.messager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.messager.Screen.MainAppBar
import com.example.messager.Screen.UserList
import com.example.messager.data.ChatScreen
import com.example.messager.ui.theme.MessagerTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            Scaffold(
                topBar = { MainAppBar() },
                content = {PaddingValues ->
                MessagerTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),

                        color = MaterialTheme.colors.background
                    ) {
                        // prueba
                        //prueba2
                        //
                       // UserList()
                        ChatScreen(Modifier.padding(PaddingValues)/*,messages = messages*/)
                    }
                }
            }
            )
        }
    }
}

