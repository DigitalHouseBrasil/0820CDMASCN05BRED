package com.lucas.whatsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.lucas.whatsapp.viewpager.adapter.ViewPagerAdapter
import com.lucas.whatsapp.viewpager.call.CallFragment
import com.lucas.whatsapp.viewpager.chat.ChatFragment
import com.lucas.whatsapp.viewpager.status.StatusFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentChat = ChatFragment()
        val fragmentStatus = StatusFragment()
        val fragmentCall = CallFragment()

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        tabLayout.setupWithViewPager(viewPager)
        val fragments = listOf(fragmentChat, fragmentStatus, fragmentCall)
        val titles = listOf("Chats", "Status", "Calls")
        viewPager.adapter = ViewPagerAdapter(fragments, titles, supportFragmentManager)

    }
}
