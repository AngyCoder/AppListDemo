package com.example.applistdemo.domain.repository

import com.example.applistdemo.data.model.App

interface AppListRepository {
    suspend fun getAppList(): List<App>
}