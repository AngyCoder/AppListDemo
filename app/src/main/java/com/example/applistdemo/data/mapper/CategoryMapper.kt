package com.example.applistdemo.data.mapper

import com.example.applistdemo.domain.appdetails.Category
import javax.inject.Inject

class CategoryMapper @Inject constructor() {

    fun mapToDomain(category: String): Category {
        return when (category.lowercase()) {
            "финансы" -> Category.FINANCE
            "инструменты" -> Category.UTILITIES
            "транспорт" -> Category.MAPS
            "игры" -> Category.GAME
            "социальные сети" -> Category.SOCIAL
            "образование" -> Category.EDUCATION
            "развлечения" -> Category.ENTERTAINMENT
            "музыка" -> Category.MUSIC
            "видео" -> Category.VIDEO
            "фотография" -> Category.PHOTOGRAPHY
            "здоровье" -> Category.HEALTH
            "спорт" -> Category.SPORTS
            "новости" -> Category.NEWS
            "книги" -> Category.BOOKS
            "бизнес" -> Category.BUSINESS
            "путешествия" -> Category.TRAVEL
            "еда" -> Category.FOOD
            "покупки" -> Category.SHOPPING
            else -> Category.APP
        }
    }
}