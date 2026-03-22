package com.example.applistdemo.data.mapper

import com.example.applistdemo.data.dto.AppDetailsDto
import com.example.applistdemo.domain.appdetails.AppDetails

/**
 * Маппер для конвертации AppDetailsDto в доменную модель AppDetails
 */
class AppDetailsMapper(
    private val categoryMapper: CategoryMapper
) {

    fun mapToDomain(dto: AppDetailsDto): AppDetails {
        return AppDetails(
            id = dto.id,
            name = dto.name,
            developer = dto.developer,
            category = categoryMapper.mapToDomain(dto.category),
            ageRating = dto.ageRating,
            size = dto.size,
            iconResId = dto.iconResId,
            screenshotResIds = dto.screenshotResIds,
            description = dto.description
        )
    }
}