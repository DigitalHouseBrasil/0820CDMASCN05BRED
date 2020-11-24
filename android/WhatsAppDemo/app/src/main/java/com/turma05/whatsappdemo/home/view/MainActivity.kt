package com.turma05.whatsappdemo.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.turma05.whatsappdemo.home.contact.view.ContactFragment
import com.turma05.whatsappdemo.R
import com.turma05.whatsappdemo.home.call.view.CallFragment
import com.turma05.whatsappdemo.home.status.view.StatusFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        tabLayout.setupWithViewPager(viewPager)

        val fragments = listOf(CallFragment(), StatusFragment(), ContactFragment())
        val titles = listOf(getString(R.string.call),
            getString(R.string.status), getString(R.string.contacts))

        viewPager.adapter = ViewPagerAdapter(fragments, titles, supportFragmentManager)
    }
}