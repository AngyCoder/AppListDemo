package com.example.applistdemo.presentation.appdetails

import androidx.compose.runtime.Immutable
import com.example.applistdemo.domain.appdetails.AppDetails

// Состояние экрана деталей приложения для UI
@Immutable
sealed interface AppDetailsState {
    data object Error : AppDetailsState // Состояние ошибки при загрузке данных
    data object Loading : AppDetailsState // Состояние загрузки (данные еще не получены)
    // Состояние с успешно загруженными данными
    data class Content(
        val appDetails: AppDetails,
        val descriptionCollapsed: Boolean,
    ) : AppDetailsState
}