package com.example.applistdemo.domain.appdetails

import androidx.annotation.DrawableRes

data class AppDetails(
    val id: String,
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    @DrawableRes val iconResId: Int,
    @DrawableRes val screenshotResIds: List<Int>,
    val description: String,
)