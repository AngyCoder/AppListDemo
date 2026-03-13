package com.example.applistdemo.data

import androidx.annotation.DrawableRes

data class App(
    val id: Int,
    val name: String,
    val description: String,
    val category: String,
    @param:DrawableRes val iconResId: Int  // Добавлено "param:"
)