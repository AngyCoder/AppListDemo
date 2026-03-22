package com.example.applistdemo.presentation.appdetails

sealed class AppDetailsEvent {
    data class ShowError(val message: String) : AppDetailsEvent()
}