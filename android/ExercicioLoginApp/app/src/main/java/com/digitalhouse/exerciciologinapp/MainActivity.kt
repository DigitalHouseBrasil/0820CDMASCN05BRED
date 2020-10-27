package com.digitalhouse.exerciciologinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tab = findViewById<TabLayout>(R.id.layoutLogin)
        val pager = findViewById<ViewPager>(R.id.viewPagerLogin)

        tab.setupWithViewPager(pager)

        pager.adapter = LoginAdapter(
            listOf(LoginFragment(), LoginFragment()),
            listOf("Sign In", "Sign Up"),
            supportFragmentManager
        )
    }
}