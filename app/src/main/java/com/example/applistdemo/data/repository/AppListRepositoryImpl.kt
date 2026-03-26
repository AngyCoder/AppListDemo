package com.example.applistdemo.data.repository

import com.example.applistdemo.data.mapper.CatalogAppMapper
import com.example.applistdemo.data.network.api.AppsApi
import com.example.applistdemo.data.model.App
import com.example.applistdemo.domain.repository.AppListRepository
import javax.inject.Inject

class AppListRepositoryImpl @Inject constructor(
    private val api: AppsApi,
    private val mapper: CatalogAppMapper
) : AppListRepository {

    override suspend fun getAppList(): List<App> {
        val response = api.getCatalog()
        return mapper.mapToDomainList(response)
    }
}