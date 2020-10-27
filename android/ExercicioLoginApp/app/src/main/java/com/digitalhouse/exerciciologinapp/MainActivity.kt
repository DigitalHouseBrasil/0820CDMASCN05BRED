package com.digitalhouse.exerciciologinapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity(), IMudarTab {

    private val tab by lazy { findViewById<TabLayout>(R.id.layoutLogin) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager = findViewById<ViewPager>(R.id.viewPagerLogin)

        tab.setupWithViewPager(pager)

        pager.adapter = LoginAdapter(
            listOf(LoginFragment(), SignUpFragment()),
            listOf("Sign In", "Sign Up"),
            supportFragmentManager
        )
    }
    
    override fun mudarTab() {
        val tabNova = tab.getTabAt(1)
        tabNova?.select()
    }
}