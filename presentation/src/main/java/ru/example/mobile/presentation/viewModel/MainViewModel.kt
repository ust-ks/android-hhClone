package ru.example.mobile.presentation.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.example.mobile.data.Preferences

class MainViewModel(
    private val preferences: Preferences
) : ViewModel() {

    // todo move to base abstract VM class
    private val _inProgress: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val inProgress: StateFlow<Boolean> get() = _inProgress

    private val _isAuthorized: MutableStateFlow<Boolean> = MutableStateFlow(preferences.isAuthorized)
    val isAuthorized: StateFlow<Boolean> get() = _isAuthorized

}