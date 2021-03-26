package com.lucas.whatsapp.viewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(
    private val fragments: List<Fragment>,
    private val titles: List<String>,
    manager: FragmentManager
) : FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int) = fragments[position]

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int) = titles[position]

}
