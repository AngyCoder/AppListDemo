package com.example.applistdemo.data.mapper

import com.example.applistdemo.data.model.App
import com.example.applistdemo.data.network.dto.CatalogAppDto
import javax.inject.Inject

class CatalogAppMapper @Inject constructor() {

    fun mapToDomain(dto: CatalogAppDto): App {
        return App(
            id = dto.id,
            name = dto.name,
            description = dto.description,
            category = dto.category,
            iconUrl = dto.iconUrl
        )
    }

    fun mapToDomainList(dtos: List<CatalogAppDto>): List<App> {
        return dtos.map { mapToDomain(it) }
    }
}