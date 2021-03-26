package com.digitalhouse.exerciciologinapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

const val LOGIN_FRAGMENT = 0
const val SIGN_UP_FRAGMENT = 1

class MainActivity : AppCompatActivity(), IMudarTab {

    private val tab by lazy { findViewById<TabLayout>(R.id.layoutLogin) }
    
    private lateinit var loginFragment: LoginFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager = findViewById<ViewPager>(R.id.viewPagerLogin)

        tab.setupWithViewPager(pager)

        loginFragment = LoginFragment()

        pager.adapter = LoginAdapter(
            listOf(loginFragment, SignUpFragment()),
            listOf("Sign In", "Sign Up"),
            supportFragmentManager
        )
    }
    
    override fun mudarTab(posicaoAtual: Int) {
        val novaPosicao = if (posicaoAtual == LOGIN_FRAGMENT) {
            SIGN_UP_FRAGMENT
        } else {
            LOGIN_FRAGMENT
        }

        val tabNova = tab.getTabAt(novaPosicao)
        tabNova?.select()
    }

    override fun userNameAlterado(username: String) {
        loginFragment.userNameAlterado(username)
    }
}