package com.example.applistdemo.presentation.applist

// Одноразовые события экрана списка приложений
sealed class AppListEvent {
    data class ShowSnackbar(val message: String) : AppListEvent()
}