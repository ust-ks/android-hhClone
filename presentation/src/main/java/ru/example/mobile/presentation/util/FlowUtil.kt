package ru.example.mobile.presentation.util

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.function.Consumer

fun EditText.bindTwoWayToStateFlow(
    lifecycleOwner: LifecycleOwner,
    stateFlow: MutableStateFlow<String?>
) {
    // Обновление EditText при изменении StateFlow
    lifecycleOwner.lifecycleScope.launch {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            stateFlow.collect { value ->
                if (text.toString() != value) {
                    setText(value)
                    value?.length?.let { setSelection(it) }
                }
            }
        }
    }

    // Обновление StateFlow при изменении EditText
    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            s?.toString()?.let {
                if (it != stateFlow.value) {
                    stateFlow.value = it
                }
            }
        }
        override fun afterTextChanged(s: Editable?) {}
    })
}

fun View.bindToViewVisibleOrGone(
    lifecycleOwner: LifecycleOwner,
    stateFlow: StateFlow<Boolean>
) {
    lifecycleOwner.lifecycleScope.launch {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            stateFlow.collect { isVisible ->
                visibility = if (isVisible) View.VISIBLE else View.GONE
            }
        }
    }
}

fun Button.bindToButtonEnable(
    lifecycleOwner: LifecycleOwner,
    stateFlow: StateFlow<Boolean>
) {
    lifecycleOwner.lifecycleScope.launch {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            stateFlow.collect { isEnable ->
                isEnabled = isEnable
            }
        }
    }
}

fun View.bindToButtonEnable(
    lifecycleOwner: LifecycleOwner,
    stateFlow: StateFlow<Boolean>
) {
    lifecycleOwner.lifecycleScope.launch {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            stateFlow.collect { isEnable ->
                isEnabled = isEnable
            }
        }
    }
}

fun TextView.bindToStateFlowList(
    lifecycleOwner: LifecycleOwner,
    stateFlow: StateFlow<String?>
) {
    // Обновление EditText при изменении StateFlow
    lifecycleOwner.lifecycleScope.launch {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            stateFlow.collect { value ->
                if (text.toString() != value) {
                    text = value
                }
            }
        }
    }
}

fun<T> bindToStateFlow(
    lifecycleOwner: LifecycleOwner,
    stateFlow: StateFlow<T>,
    action: Consumer<in T>
) {
    lifecycleOwner.lifecycleScope.launch {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            stateFlow.collect { value ->
                action.accept(value)
            }
        }
    }
}

fun<T> bindToStateFlowList(
    lifecycleOwner: LifecycleOwner,
    stateFlow: StateFlow<List<T>>,
    action: Consumer<in List<T>>
) {
    lifecycleOwner.lifecycleScope.launch {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            stateFlow.collect { value ->
                action.accept(value)
            }
        }
    }
}