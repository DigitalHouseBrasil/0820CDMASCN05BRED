package com.digitalhouse.aulaviewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(private val fragments: List<Fragment>,
                       private val titulos: List<String>,
                       manager: FragmentManager): FragmentPagerAdapter(manager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    // Quantidade de tabs
    override fun getCount() = fragments.size

    // Rertornar o fragment corresponte a posição
    override fun getItem(position: Int) = fragments[position]

    // Retornar o nome da tab
    // Se eu quiser que seja exibido somente os ícones, retirar essa função
    override fun getPageTitle(position: Int) = titulos[position]
}