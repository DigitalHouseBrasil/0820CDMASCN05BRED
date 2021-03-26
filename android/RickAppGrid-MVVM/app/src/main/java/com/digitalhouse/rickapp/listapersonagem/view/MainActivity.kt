package com.digitalhouse.rickapp.listapersonagem.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.detalhepersonagem.view.DetalhesActivity
import com.digitalhouse.rickapp.R
import com.digitalhouse.rickapp.listapersonagem.model.Personagem
import com.digitalhouse.rickapp.listapersonagem.repository.ListaPersonagemRepository
import com.digitalhouse.rickapp.listapersonagem.viewmodel.ListaPersonagemViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ListaPersonagemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(
            this,
            ListaPersonagemViewModel.ListaPersonagemViewModelFactory(ListaPersonagemRepository(this))
        ).get(ListaPersonagemViewModel::class.java)
        
        viewModel.personagens.observe(this, Observer {
            criarLista(it)
        })

        viewModel.obterLista()
    }
    
    fun criarLista(personagens: List<Personagem>) {
        val recyclerView = findViewById<RecyclerView>(R.id.lista)
        val manager = GridLayoutManager(this, 2)

        val toast: Toast? = null

        val customAdapter = CustomAdapter(personagens) {
            toast?.cancel()

            val intent = Intent(this@MainActivity, DetalhesActivity::class.java)
            intent.putExtra("IMAGEM", it.imagemUrl)
            intent.putExtra("NOME", it.nome)
            intent.putExtra("GENERO", it.genero)
            intent.putExtra("PLANETA", it.localizacao.nome)

            startActivity(intent)
        }

        recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = manager
            adapter = customAdapter
        }
    }
}