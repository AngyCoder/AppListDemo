package com.example.applistdemo.data.repository

import com.example.applistdemo.data.datasource.LocalAppDataSource
import com.example.applistdemo.data.mapper.AppDetailsMapper
import com.example.applistdemo.domain.appdetails.AppDetails
import com.example.applistdemo.domain.repository.AppDetailsRepository
import javax.inject.Inject

/**
 * Реализация репозитория для получения детальной информации о приложении
 */
class AppDetailsRepositoryImpl @Inject constructor(
    private val localDataSource: LocalAppDataSource,
    private val mapper: AppDetailsMapper
) : AppDetailsRepository {

    override suspend fun getAppDetails(appId: String): AppDetails {
        val dto = localDataSource.getAppDetails(appId)
            ?: throw IllegalArgumentException("Приложение не найдено с id: $appId")

        return mapper.mapToDomain(dto)
    }
}