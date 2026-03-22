package com.example.applistdemo.presentation.appdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applistdemo.domain.usecase.GetAppDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    private val getAppDetailsUseCase: GetAppDetailsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state: StateFlow<AppDetailsState> = _state.asStateFlow()

    private val _events = Channel<AppDetailsEvent>()
    val events = _events.receiveAsFlow()

    private val _descriptionCollapsed = MutableStateFlow(true)
    val descriptionCollapsed: StateFlow<Boolean> = _descriptionCollapsed.asStateFlow()

    fun loadAppDetails(appId: String) {
        viewModelScope.launch {
            _state.value = AppDetailsState.Loading

            getAppDetailsUseCase(appId)
                .onSuccess { appDetails ->
                    _state.value = AppDetailsState.Content(appDetails)
                }
                .onFailure { exception ->
                    _state.value = AppDetailsState.Error
                    _events.send(AppDetailsEvent.ShowError(exception.message ?: "Неизвестная ошибка"))
                }
        }
    }

    fun toggleDescription() {
        _descriptionCollapsed.value = !_descriptionCollapsed.value
    }
}