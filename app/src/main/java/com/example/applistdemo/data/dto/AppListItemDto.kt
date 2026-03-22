package com.example.applistdemo.data.dto

import androidx.annotation.DrawableRes

/**
 * DTO модель для элемента списка приложений
 */
data class AppListItemDto(
    val id: Int,
    val name: String,
    val description: String,
    val category: String,
    @field:DrawableRes val iconResId: Int
)