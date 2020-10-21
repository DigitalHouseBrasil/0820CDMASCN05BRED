package com.digitalhouse.rickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.api.IRespostaDaApi
import com.digitalhouse.rickapp.api.Personagem
import com.digitalhouse.rickapp.api.RickApi
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        RickApi.getData(this, object: IRespostaDaApi {
            override fun obtevePersonagens(personagens: List<Personagem>) {
                criarLista(personagens)
            }
        })
    }
    
    fun criarLista(personagens: List<Personagem>) {
        val recyclerView = findViewById<RecyclerView>(R.id.lista)
        val manager = GridLayoutManager(this, 2)

        val customAdapter = CustomAdapter(personagens)

        recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = manager
            adapter = customAdapter
        }
    }
}