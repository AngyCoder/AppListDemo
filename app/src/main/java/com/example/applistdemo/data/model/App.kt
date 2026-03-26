package com.example.applistdemo.data.model

data class App(
    val id: Int,
    val name: String,
    val description: String,
    val category: String,
    val iconUrl: String  // URL иконки с сервера
)