package com.example.applistdemo.data.dto

import androidx.annotation.DrawableRes

/**
 * DTO модель для получения данных от источника (хардкод/API)
 */
data class AppDetailsDto(
    val id: String,
    val name: String,
    val developer: String,
    val category: String,  // В DTO категория как строка
    val ageRating: Int,
    val size: Float,
    @field:DrawableRes val iconResId: Int,
    @field:DrawableRes val screenshotResIds: List<Int>,
    val description: String
)