package com.debug.authentication.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HomeViewPagerAdapter (manager: FragmentManager) : FragmentPagerAdapter(manager){

    private val listFragment: MutableList<Fragment> = ArrayList()
    private val listTitleInvoice: MutableList<String> = ArrayList()

    override fun getCount(): Int {
        return listFragment.size
    }

    override fun getItem(position: Int): Fragment {
        return listFragment[position]
    }

    fun addFragment (fragment: Fragment, titleIncoive: String) {
        listFragment.add(fragment)
        listTitleInvoice.add(titleIncoive)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return listTitleInvoice[position]
    }
}