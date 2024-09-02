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

class LoginStep2ViewModel(
    private val preferences: Preferences
) : ViewModel() {

    private val _inProgress: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val inProgress: StateFlow<Boolean> get() = _inProgress

    var email: MutableStateFlow<String?> = MutableStateFlow(preferences.email)

    var authCode1: MutableStateFlow<String?> = MutableStateFlow(null)
    var authCode2: MutableStateFlow<String?> = MutableStateFlow(null)
    var authCode3: MutableStateFlow<String?> = MutableStateFlow(null)
    var authCode4: MutableStateFlow<String?> = MutableStateFlow(null)

    val isConfirmButtonEnable: StateFlow<Boolean> =
        combine(authCode1, authCode2, authCode3, authCode4, _inProgress) {
                authCode1, authCode2, authCode3, authCode4, _inProgress ->
            !_inProgress &&
                    authCode1 != null &&
                    authCode2 != null &&
                    authCode3 != null &&
                    authCode4 != null &&
                    authCode1.isNotBlank() &&
                    authCode2.isNotBlank() &&
                    authCode3.isNotBlank() &&
                    authCode4.isNotBlank()
        }.stateIn(
            scope = CoroutineScope(Dispatchers.Default),
            started = SharingStarted.Eagerly,
            initialValue = false
        )
}