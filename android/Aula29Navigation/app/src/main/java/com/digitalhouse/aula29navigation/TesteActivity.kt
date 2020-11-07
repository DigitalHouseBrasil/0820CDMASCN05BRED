package com.digitalhouse.aula29navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import androidx.navigation.navArgs

class TesteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)

        findViewById<Switch>(R.id.switch1).text = intent.getStringExtra("ANIMAL")
    }
}