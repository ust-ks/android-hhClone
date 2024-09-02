package ru.example.mobile.presentation.util

import android.view.View

fun<T> View.onClickListener(onClickListener: () -> T?) = setOnClickListener {
    onClickListener.invoke()
}