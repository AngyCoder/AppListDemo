package com.example.applistdemo.data.network.api

import com.example.applistdemo.data.network.dto.AppDetailsDto
import com.example.applistdemo.data.network.dto.CatalogAppDto
import retrofit2.http.GET
import retrofit2.http.Path

interface AppsApi {

    @GET("catalog")
    suspend fun getCatalog(): List<CatalogAppDto>

    @GET("catalog/{id}")
    suspend fun getAppDetails(@Path("id") id: String): AppDetailsDto
}