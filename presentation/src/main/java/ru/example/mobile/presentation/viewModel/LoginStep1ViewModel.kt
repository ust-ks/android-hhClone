package ru.example.mobile.presentation.viewModel

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import ru.example.mobile.data.Preferences
import ru.example.mobile.data.Repository

class LoginStep1ViewModel(
    private val preferences: Preferences
) : ViewModel() {

    private val _inProgress: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val inProgress: StateFlow<Boolean> get() = _inProgress

    var email: MutableStateFlow<String?> = MutableStateFlow(preferences.email)

    val isContinueButtonEnable: StateFlow<Boolean> =
        combine(email, _inProgress) { email, _inProgress ->
            !_inProgress && email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }.stateIn(
            scope = CoroutineScope(Dispatchers.Default),
            started = SharingStarted.Eagerly,
            initialValue = false
        )

    fun onContinueClick() {
        _inProgress.value = true
        preferences.email = email.value
    }

}