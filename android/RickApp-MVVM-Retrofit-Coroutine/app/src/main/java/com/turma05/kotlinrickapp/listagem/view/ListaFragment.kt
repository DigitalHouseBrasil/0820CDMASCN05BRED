package com.turma05.kotlinrickapp.listagem.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.turma05.kotlinrickapp.R
import com.turma05.kotlinrickapp.listagem.model.PersonagemModel
import com.turma05.kotlinrickapp.listagem.repository.PersonagemRepository
import com.turma05.kotlinrickapp.listagem.viewmodel.PersonagemViewModel

class ListaFragment : Fragment() {
    lateinit var _viewModel: PersonagemViewModel
    lateinit var _view: View
    private lateinit var _listaAdapter: ListaAdapter

    private var _listaDePersonagens = mutableListOf<PersonagemModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view

        val lista = view.findViewById<RecyclerView>(R.id.lista)
        val manager = LinearLayoutManager(view.context)

        _listaDePersonagens = mutableListOf()
        _listaAdapter = ListaAdapter(_listaDePersonagens)

        lista.apply {
            setHasFixedSize(true)

            layoutManager = manager
            adapter = _listaAdapter
        }

        _viewModel = ViewModelProvider(
            this,
            PersonagemViewModel.PersonagemViewModelFactory(PersonagemRepository())
        ).get(PersonagemViewModel::class.java)

        _viewModel.obterLista().observe(viewLifecycleOwner, {
            exibirResultados(it)
        })

        showLoading(true)

        initSearch()
        setScrollView()
    }

    private fun exibirResultados(lista: List<PersonagemModel>?) {
        showLoading(false)

        lista?.isNotEmpty()?.let { notfound(it) }

        lista?.let { _listaDePersonagens.addAll(it) }

        _listaAdapter.notifyDataSetChanged()
    }

    private fun initSearch() {
        val searchView = _view.findViewById<SearchView>(R.id.searchView)

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()

                _viewModel.buscar(query).observe(viewLifecycleOwner, {
                    _listaDePersonagens.clear()
                    exibirResultados(it)
                })

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    _listaDePersonagens.clear()
                    exibirResultados(_viewModel.listaAntiga())
                }

                return true
            }
        })
    }

    private fun setScrollView() {
        _view.findViewById<RecyclerView>(R.id.lista).addOnScrollListener(object :
            RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val target = recyclerView.layoutManager as LinearLayoutManager?

                val totalItemCount = target!!.itemCount

                val lastVisible = target.findLastVisibleItemPosition()

                val lastItem = lastVisible + 5 >= totalItemCount

                if (totalItemCount > 0 && lastItem) {
                    _viewModel.proximaPagina().observe(viewLifecycleOwner, {
                        exibirResultados(it)
                    })
                }
            }
        })
    }

    fun showLoading(isLoading: Boolean) {
        val viewLoading = _view.findViewById<View>(R.id.loading)

        if (isLoading) {
            viewLoading.visibility = View.VISIBLE
        } else {
            viewLoading.visibility = View.GONE
        }
    }

    fun notfound(notfound: Boolean) {
        if (notfound) {
            _view.findViewById<View>(R.id.notfoundLayout).visibility = View.GONE
        } else {
            _view.findViewById<View>(R.id.notfoundLayout).visibility = View.VISIBLE
        }
    }
}