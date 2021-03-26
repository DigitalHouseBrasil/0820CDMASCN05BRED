package com.digitalhouse.rickapp.detalhepersonagem.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.digitalhouse.rickapp.R
import com.squareup.picasso.Picasso

class DetalhesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        val imagem = intent.getStringExtra("IMAGEM")
        val nome = intent.getStringExtra("NOME")
        val planeta = intent.getStringExtra("PLANETA")
        val genero = intent.getStringExtra("GENERO")

        findViewById<TextView>(R.id.txtNome).text = nome
        findViewById<TextView>(R.id.txtGenero).text = genero
        findViewById<TextView>(R.id.txtPlaneta).text = planeta

        Picasso.get()
            .load(imagem)
            .into(findViewById<ImageView>(R.id.imagem))
    }
}