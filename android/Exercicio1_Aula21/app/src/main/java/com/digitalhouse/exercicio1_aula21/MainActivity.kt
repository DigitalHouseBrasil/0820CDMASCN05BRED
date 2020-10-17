package com.digitalhouse.exercicio1_aula21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var manager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = supportFragmentManager

        btnPrimeiro.setOnClickListener {
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.container, PrimeiroFragment())
            transaction.commit()
        }

        btnSegundo.setOnClickListener {
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.container, SegundoFragment())
            transaction.commit()
        }
    }
}