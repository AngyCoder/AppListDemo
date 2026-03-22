package com.example.applistdemo.presentation.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applistdemo.domain.repository.AppListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// Добавляем @HiltViewModel
@HiltViewModel
class AppListViewModel @Inject constructor(
    private val repository: AppListRepository  // Теперь получаем через DI
) : ViewModel() {

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

            try {
                val apps = repository.getAppList()
                _state.value = AppListState.Content(apps)
            } catch (e: Exception) {
                _state.value = AppListState.Error
                _events.send(AppListEvent.ShowSnackbar("Ошибка загрузки: ${e.message}"))
            }
        }
    }

    fun onLogoClick(appName: String) {
        viewModelScope.launch {
            _events.send(AppListEvent.ShowSnackbar("Логотип приложения: $appName"))
        }
    }
}