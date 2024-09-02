package ru.example.mobile.presentation.viewModel

import androidx.lifecycle.ViewModel
import ru.example.mobile.data.Repository

class VacanciesForYouViewModel(
    private val repository: Repository
) : ViewModel() {

    init {
        repository.fetchData()
    }

}