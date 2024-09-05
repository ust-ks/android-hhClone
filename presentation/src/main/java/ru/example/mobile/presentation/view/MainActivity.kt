package ru.example.mobile.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.example.mobile.presentation.R
import ru.example.mobile.presentation.databinding.ActivityMainBinding
import ru.example.mobile.presentation.view.auth.LoginStep1Fragment
import ru.example.mobile.presentation.view.base.BaseActivity
import ru.example.mobile.presentation.viewModel.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val viewModel by viewModel<MainViewModel>()
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.containerAuth.visibility = View.VISIBLE
        setupContainers()
        setupNavigationMenu()
    }

    private fun setupContainers() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container_auth, LoginStep1Fragment())
            .commit()

//        supportFragmentManager.beginTransaction()
//            .addToBackStack(null)
//            .replace(R.id.container_search, LoginStep1Fragment())
//            .commit()

//        supportFragmentManager.beginTransaction()
//            .addToBackStack(null)
//            .replace(R.id.container_favorites, LoginStep1Fragment())
//            .commit()
    }

    private fun setupNavigationMenu() {
        binding.navMenu.setOnItemSelectedListener {
            hideAllContainers()
            // todo проверка авторизации тут
            when(it.itemId) {
                R.id.nav_search -> binding.containerAuth.visibility = View.VISIBLE
                R.id.nav_profile -> binding.containerFavorite.visibility = View.VISIBLE
                R.id.nav_responses -> 2
                R.id.nav_messages -> 3
                R.id.nav_profile -> 4
                else -> 4
            }
            return@setOnItemSelectedListener true
        }

    }

    private fun hideAllContainers() {
        binding.containerAuth.visibility = View.GONE
        binding.containerSearch.visibility = View.GONE
        binding.containerFavorite.visibility = View.GONE
    }

}