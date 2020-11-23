package com.turma05.whatsappdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        tabLayout.setupWithViewPager(viewPager)

        val fragments = listOf(ContactFragment(), ContactFragment(), ContactFragment())
        val titles = listOf(getString(R.string.call),
            getString(R.string.status), getString(R.string.contacts))

        viewPager.adapter = ViewPagerAdapter(fragments, titles, supportFragmentManager)
    }
}