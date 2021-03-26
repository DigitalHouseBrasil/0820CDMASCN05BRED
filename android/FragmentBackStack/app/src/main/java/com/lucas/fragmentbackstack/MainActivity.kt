package com.lucas.fragmentbackstack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), FragmentManager.OnBackStackChangedListener {

    private val btnOne by lazy { findViewById<Button>(R.id.btn_one) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciaPrimeiroFragment()

        aoClicarExibeSegundoFragment()

    }

    private fun iniciaPrimeiroFragment() {
        supportFragmentManager.addOnBackStackChangedListener(this)
        supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, PrimeiroFragment())
                .addToBackStack(null)
                .commit()
    }

    private fun aoClicarExibeSegundoFragment() {
        btnOne.setOnClickListener {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, SegundoFragment())
                    .addToBackStack(null)
                    .commit()
            btnOne.visibility = View.INVISIBLE

        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 2) {
            btnOne.visibility = View.VISIBLE
            super.onBackPressed()

        } else {
            finish()
        }
    }

    override fun onBackStackChanged() {
        val findFragmentById = supportFragmentManager.findFragmentById(R.id.frameLayout)
        if (findFragmentById is PrimeiroFragment) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        } else if (findFragmentById is SegundoFragment) run {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}