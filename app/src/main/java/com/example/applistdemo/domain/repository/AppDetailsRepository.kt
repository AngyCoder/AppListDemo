package com.example.applistdemo.domain.repository

import com.example.applistdemo.domain.appdetails.AppDetails

// Интерфейс репозитория для получения детальной информации о приложении

interface AppDetailsRepository {
    suspend fun getAppDetails(appId: String): AppDetails
}