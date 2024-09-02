package ru.example.mobile.presentation.view.auth

import android.view.LayoutInflater
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.example.mobile.presentation.R
import ru.example.mobile.presentation.databinding.FragmentLoginStep1Binding
import ru.example.mobile.presentation.util.bindToButtonEnable
import ru.example.mobile.presentation.util.bindTwoWayToStateFlow
import ru.example.mobile.presentation.util.onClickListener
import ru.example.mobile.presentation.view.base.BaseFragment
import ru.example.mobile.presentation.viewModel.LoginStep1ViewModel

class LoginStep1Fragment : BaseFragment<LoginStep1ViewModel, FragmentLoginStep1Binding>() {

    override val viewModel by viewModel<LoginStep1ViewModel>()
    override val bindingInflater: (LayoutInflater) -> FragmentLoginStep1Binding = FragmentLoginStep1Binding::inflate

    override fun setupUI() {
        binding.apply {
            emailEditText.bindTwoWayToStateFlow(this@LoginStep1Fragment, viewModel.email)
            continueButton.bindToButtonEnable(this@LoginStep1Fragment, viewModel.isContinueButtonEnable)
            continueButton.onClickListener {
                viewModel.onContinueClick()
                showLoginStep2Fragment()
            }
        }
    }

    private fun showLoginStep2Fragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container_auth, LoginStep2Fragment())
            .commit()
    }
}