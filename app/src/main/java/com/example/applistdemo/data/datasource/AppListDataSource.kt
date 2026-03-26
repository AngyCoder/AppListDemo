package com.example.applistdemo.data.datasource

import com.example.applistdemo.data.model.App
import com.example.applistdemo.data.network.api.AppsApi
import javax.inject.Inject

class AppListDataSource @Inject constructor(
    private val api: AppsApi
) {

    suspend fun getAppList(): List<App> {
        return try {
            val response = api.getCatalog()
            response.map { dto ->
                App(
                    id = dto.id,
                    name = dto.name,
                    description = dto.description,
                    category = dto.category,
                    iconUrl = dto.iconUrl
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}