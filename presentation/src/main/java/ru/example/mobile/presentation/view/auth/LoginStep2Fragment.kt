package ru.example.mobile.presentation.view.auth

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.EditText
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.example.mobile.presentation.R
import ru.example.mobile.presentation.databinding.FragmentLoginStep2Binding
import ru.example.mobile.presentation.util.bindToButtonEnable
import ru.example.mobile.presentation.util.bindTwoWayToStateFlow
import ru.example.mobile.presentation.util.onClickListener
import ru.example.mobile.presentation.view.base.BaseFragment
import ru.example.mobile.presentation.view.search.VacanciesForYouFragment
import ru.example.mobile.presentation.viewModel.LoginStep2ViewModel

class LoginStep2Fragment : BaseFragment<LoginStep2ViewModel, FragmentLoginStep2Binding>() {

    override val viewModel by viewModel<LoginStep2ViewModel>()
    override val bindingInflater: (LayoutInflater) -> FragmentLoginStep2Binding = FragmentLoginStep2Binding::inflate

    @SuppressLint("SetTextI18n")
    override fun setupUI() {
        binding.apply {
            sentCodeTitle.text = "Отправили код на " + viewModel.email.value

            authCode1.bindTwoWayToStateFlow(this@LoginStep2Fragment, viewModel.authCode1)
            authCode2.bindTwoWayToStateFlow(this@LoginStep2Fragment, viewModel.authCode2)
            authCode3.bindTwoWayToStateFlow(this@LoginStep2Fragment, viewModel.authCode3)
            authCode4.bindTwoWayToStateFlow(this@LoginStep2Fragment, viewModel.authCode4)

            confirmButton.bindToButtonEnable(this@LoginStep2Fragment, viewModel.isConfirmButtonEnable)
            confirmButton.onClickListener { showVacanciesFragment() }

            setupEditTextSwitcher(authCode1, authCode2)
            setupEditTextSwitcher(authCode2, authCode3)
            setupEditTextSwitcher(authCode3, authCode4)
            setupEditTextSwitcher(authCode4, null)
        }
    }

    private fun setupEditTextSwitcher(currentEditText: EditText, nextEditText: EditText?) {
        currentEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s != null && s.length == 1) {
                    nextEditText?.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    private fun showVacanciesFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container_auth, VacanciesForYouFragment())
            .commit()
    }

}