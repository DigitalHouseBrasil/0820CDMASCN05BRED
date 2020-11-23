package com.lucas.whatsapp.viewpager.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucas.whatsapp.R
import com.lucas.whatsapp.model.CharacterModel
import com.lucas.whatsapp.repository.CharacterRepository
import com.lucas.whatsapp.viewmodel.CharacterViewModel
import com.lucas.whatsapp.viewpager.chat.adapter.ChatAdapter

class ChatFragment : Fragment() {

    private lateinit var _viewModel: CharacterViewModel
    private lateinit var _view: View
    private lateinit var _listaAdapter: ChatAdapter
    private lateinit var recyclerView: RecyclerView

    private var _listaDePersonagens = mutableListOf<CharacterModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _view = view

        recyclerView = _view.findViewById(R.id.rv_message)
        val manager = LinearLayoutManager(view.context)

        _listaDePersonagens = mutableListOf()
        _listaAdapter = ChatAdapter(_listaDePersonagens)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = manager
            adapter = _listaAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        _viewModel = ViewModelProvider(
            this,
            CharacterViewModel.PersonagemViewModelFactory(CharacterRepository())
        ).get(CharacterViewModel::class.java)

        _viewModel.obterLista().observe(viewLifecycleOwner) {
            exibirResultados(it)
        }
    }

    private fun exibirResultados(lista: List<CharacterModel>?) {

        lista?.let { _listaDePersonagens.addAll(lista) }
        _listaAdapter.notifyDataSetChanged()
    }

}