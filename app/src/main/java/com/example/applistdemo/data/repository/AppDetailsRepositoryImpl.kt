package com.example.applistdemo.data.repository

import com.example.applistdemo.data.mapper.AppDetailsNetworkMapper
import com.example.applistdemo.data.network.api.AppsApi
import com.example.applistdemo.domain.appdetails.AppDetails
import com.example.applistdemo.domain.repository.AppDetailsRepository
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val api: AppsApi,
    private val mapper: AppDetailsNetworkMapper
) : AppDetailsRepository {

    override suspend fun getAppDetails(appId: String): AppDetails {
        val response = api.getAppDetails(appId)
        return mapper.mapToDomain(response)
    }
}