package ru.example.mobile.presentation.view.search

import android.view.LayoutInflater
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.example.mobile.presentation.databinding.FragmentVacanciesForYouBinding
import ru.example.mobile.presentation.view.base.BaseFragment
import ru.example.mobile.presentation.viewModel.VacanciesForYouViewModel

class VacanciesForYouFragment : BaseFragment<VacanciesForYouViewModel, FragmentVacanciesForYouBinding>() {

    override val viewModel by viewModel<VacanciesForYouViewModel>()
    override val bindingInflater: (LayoutInflater) -> FragmentVacanciesForYouBinding = FragmentVacanciesForYouBinding::inflate

    override fun setupUI() {
        TODO("Not yet implemented")
    }

}