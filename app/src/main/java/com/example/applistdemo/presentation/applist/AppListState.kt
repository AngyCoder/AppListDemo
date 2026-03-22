package com.example.applistdemo.presentation.applist

// Состояние экрана списка приложений
sealed class AppListState {
    object Loading : AppListState()
    data class Content(val apps: List<App>) : AppListState()
    object Error : AppListState()
}