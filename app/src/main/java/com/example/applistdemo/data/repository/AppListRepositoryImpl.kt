package com.example.applistdemo.data.repository

import com.example.applistdemo.data.datasource.AppListDataSource
import com.example.applistdemo.data.model.App
import com.example.applistdemo.domain.repository.AppListRepository
import javax.inject.Inject

class AppListRepositoryImpl @Inject constructor(
    private val dataSource: AppListDataSource
) : AppListRepository {

    override suspend fun getAppList(): List<App> {
        return dataSource.getAppList()
    }
}