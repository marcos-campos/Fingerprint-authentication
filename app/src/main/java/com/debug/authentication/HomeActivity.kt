package com.debug.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.debug.authentication.ui.main.CurrentInvoiceFragment
import com.debug.authentication.ui.main.HomeFragment
import com.debug.authentication.ui.main.HomeViewPagerAdapter

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance())
                .commitNow()
        }
    }
}