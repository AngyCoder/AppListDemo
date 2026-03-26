package com.example.applistdemo.domain.appdetails

import androidx.annotation.DrawableRes

// Доменная модель детальной информации о приложении

data class AppDetails(
    val id: String,
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    val iconUrl: String,  // URL иконки с сервера
    val screenshotUrls: List<String>,  // URL скриншотов
    val description: String
)