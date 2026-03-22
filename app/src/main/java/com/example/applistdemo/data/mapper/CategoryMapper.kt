package com.example.applistdemo.data.mapper

import com.example.applistdemo.domain.appdetails.Category

/**
 * Маппер для конвертации строковой категории из DTO в доменную Category
 */
class CategoryMapper {

    fun mapToDomain(category: String): Category {
        return when (category) {
            "Финансы" -> Category.FINANCE
            "Инструменты" -> Category.UTILITIES
            "Транспорт" -> Category.MAPS
            "Социальные сети" -> Category.SOCIAL
            "Игры" -> Category.GAME
            "Образование" -> Category.EDUCATION
            "Развлечения" -> Category.ENTERTAINMENT
            "Музыка" -> Category.MUSIC
            "Видео" -> Category.VIDEO
            "Фотография" -> Category.PHOTOGRAPHY
            "Здоровье" -> Category.HEALTH
            "Спорт" -> Category.SPORTS
            "Новости" -> Category.NEWS
            "Книги" -> Category.BOOKS
            "Бизнес" -> Category.BUSINESS
            "Путешествия" -> Category.TRAVEL
            "Еда" -> Category.FOOD
            "Покупки" -> Category.SHOPPING
            else -> Category.APP
        }
    }
}