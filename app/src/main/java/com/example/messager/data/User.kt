package com.example.messager.data

data class User(
        val id: String,
        val name: String,
        val email: String,
        //val profileImage: String
    )


val userList = listOf(
    User("1", "Juan", "juan@example.com",),
    User("2", "Maria", "maria@example.com"),
    User("3", "Pedro", "pedro@example.com")
)
