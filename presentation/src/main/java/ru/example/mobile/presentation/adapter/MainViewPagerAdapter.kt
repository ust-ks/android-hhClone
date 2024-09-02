package ru.example.mobile.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.example.mobile.presentation.view.auth.LoginStep1Fragment

class MainViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity){

    private var arrayFragments: ArrayList<Fragment> = arrayListOf(
        LoginStep1Fragment()
    )

    override fun getItemCount(): Int = arrayFragments.size

    override fun createFragment(position: Int): Fragment = arrayFragments[position]

}