package com.example.applistdemo.data.mapper

import com.example.applistdemo.data.network.dto.AppDetailsDto
import com.example.applistdemo.domain.appdetails.AppDetails
import com.example.applistdemo.domain.appdetails.Category
import javax.inject.Inject

class AppDetailsNetworkMapper @Inject constructor() {

    fun mapToDomain(dto: AppDetailsDto): AppDetails {
        return AppDetails(
            id = dto.id,
            name = dto.name,
            developer = dto.developer,
            category = mapCategory(dto.category),
            ageRating = dto.ageRating,
            size = dto.size,
            iconUrl = dto.iconUrl,
            screenshotUrls = dto.screenshotUrls,
            description = dto.description
        )
    }

    private fun mapCategory(category: String): Category {
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