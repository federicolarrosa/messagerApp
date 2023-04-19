package com.example.messager.Screen

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.messager.data.userList
import com.example.messager.ui.theme.MessagerTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(onNavigate: (item:String) -> Unit) {
    Scaffold(
        topBar = { MainAppBar() },
        content = {PaddingValues ->
            MessagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),

                    color = MaterialTheme.colors.background
                ) {

                    UserList(modifier = Modifier.padding(PaddingValues),
                        users= userList,
                        onClick = {onNavigate(it.id)
                            Log.d("prueba", it.toString())
                        })
                    //ChatScreen(Modifier.padding(PaddingValues)/*,messages = messages*/)
                }
            }
        }
    )
}
