package com.turma05.kotlinrickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.turma05.kotlinrickapp.listagem.view.ListaFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, ListaFragment())
            .commit()
    }
}