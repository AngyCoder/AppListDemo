package com.example.applistdemo.presentation.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applistdemo.data.datasource.AppListDataSource
import com.example.applistdemo.data.model.App
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class AppListState {
    data object Loading : AppListState()
    data class Content(val apps: List<App>) : AppListState()
    data object Error : AppListState()
}

sealed class AppListEvent {
    data class ShowSnackbar(val message: String) : AppListEvent()
}

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val dataSource: AppListDataSource
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
                val apps = dataSource.getAppList()
                if (apps.isNotEmpty()) {
                    _state.value = AppListState.Content(apps)
                } else {
                    _state.value = AppListState.Error
                    _events.send(AppListEvent.ShowSnackbar("Нет данных"))
                }
            } catch (e: Exception) {
                _state.value = AppListState.Error
                _events.send(AppListEvent.ShowSnackbar("Ошибка: ${e.message}"))
            }
        }
    }

    fun onLogoClick(appName: String) {
        viewModelScope.launch {
            _events.send(AppListEvent.ShowSnackbar("Логотип: $appName"))
        }
    }
}