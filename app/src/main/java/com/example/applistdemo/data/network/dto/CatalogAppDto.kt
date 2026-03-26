package com.example.applistdemo.data.network.dto

import com.google.gson.annotations.SerializedName

data class CatalogAppDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("category")
    val category: String,

    @SerializedName("iconUrl")
    val iconUrl: String
)