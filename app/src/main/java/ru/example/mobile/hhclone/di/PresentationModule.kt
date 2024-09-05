package ru.example.mobile.hhclone.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.example.mobile.presentation.viewModel.LoginStep1ViewModel
import ru.example.mobile.presentation.viewModel.LoginStep2ViewModel
import ru.example.mobile.presentation.viewModel.MainViewModel

fun presentationModule() = module {
    viewModel { MainViewModel(get()) }
    viewModel { LoginStep1ViewModel(get()) }
    viewModel { LoginStep2ViewModel(get()) }
}