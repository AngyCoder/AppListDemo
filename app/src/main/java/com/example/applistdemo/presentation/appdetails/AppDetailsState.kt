package com.example.applistdemo.presentation.appdetails

import com.example.applistdemo.domain.appdetails.AppDetails

sealed class AppDetailsState {
    data object Loading : AppDetailsState()
    data class Content(val appDetails: AppDetails) : AppDetailsState()
    data object Error : AppDetailsState()
}