package com.example.applistdemo.data.model

import androidx.annotation.DrawableRes

/**
 * Модель данных для списка приложений
 */
data class App(
    val id: Int,
    val name: String,
    val description: String,
    val category: String,
    @DrawableRes val iconResId: Int
)