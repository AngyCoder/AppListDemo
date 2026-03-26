package com.example.applistdemo.data.repository

import com.example.applistdemo.data.network.api.AppsApi
import com.example.applistdemo.domain.appdetails.AppDetails
import com.example.applistdemo.domain.repository.AppDetailsRepository
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val api: AppsApi
) : AppDetailsRepository {

    override suspend fun getAppDetails(appId: String): AppDetails {
        val response = api.getAppDetails(appId)
        return AppDetails(
            id = response.id,
            name = response.name,
            developer = response.developer,
            category = when (response.category.lowercase()) {
                "финансы" -> com.example.applistdemo.domain.appdetails.Category.FINANCE
                "инструменты" -> com.example.applistdemo.domain.appdetails.Category.UTILITIES
                "транспорт" -> com.example.applistdemo.domain.appdetails.Category.MAPS
                "игры" -> com.example.applistdemo.domain.appdetails.Category.GAME
                else -> com.example.applistdemo.domain.appdetails.Category.APP
            },
            ageRating = response.ageRating,
            size = response.size,
            iconUrl = response.iconUrl,
            screenshotUrls = response.screenshotUrls,
            description = response.description
        )
    }
}