package com.debug.authentication.ui.main

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.debug.authentication.R
import com.google.android.material.tabs.TabLayout
import java.util.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapterHome = activity?.let { HomeViewPagerAdapter(it.supportFragmentManager) }

        adapterHome?.addFragment(CurrentInvoiceFragment(), "Fatura atual")
        adapterHome?.addFragment(NextInvoiceFragment(), "Próxima fatura")

        val viewPagerHome = view?.findViewById<ViewPager>(R.id.home_view_pager)
        viewPagerHome.adapter = adapterHome

        val tabLayoutHome = view?.findViewById<TabLayout>(R.id.home_tab_layout)
        tabLayoutHome.setupWithViewPager(viewPagerHome)
    }
}