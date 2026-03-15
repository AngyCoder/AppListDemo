package com.example.applistdemo.presentation.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applistdemo.data.DataSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

/**
 * ViewModel для экрана списка приложений
 * Хранит состояние и обрабатывает события
 */
class AppListViewModel : ViewModel() {

    private val _state = MutableStateFlow<AppListState>(AppListState.Loading)
    val state: StateFlow<AppListState> = _state.asStateFlow()

    private val _events = Channel<AppListEvent>()
    val events = _events.receiveAsFlow()

    init {
        loadApps()
    }

    fun loadApps() {
        viewModelScope.launch {
            _state.value = AppListState.Loading
            delay(500)

            try {
                val apps = DataSource.appList
                _state.value = AppListState.Content(apps)
            } catch (e: Exception) {
                _state.value = AppListState.Error
                _events.send(AppListEvent.ShowSnackbar("Ошибка загрузки"))
            }
        }
    }

    fun onLogoClick(appName: String) {
        viewModelScope.launch {
            _events.send(AppListEvent.ShowSnackbar("Логотип приложения: $appName"))
        }
    }
}