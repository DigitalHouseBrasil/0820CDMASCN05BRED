package com.turma05.aula40.tarefa.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.turma05.aula39.db.AppDatabase
import com.turma05.aula40.R
import com.turma05.aula40.tarefa.entity.TarefaEntity
import com.turma05.aula40.tarefa.repository.TarefaRepository
import com.turma05.aula40.tarefa.viewmodel.TarefaViewModel

class TarefaFragment : Fragment() {

    private lateinit var _view: View
    private lateinit var _viewModel: TarefaViewModel
    private lateinit var _adapter: TarefaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tarefa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view
        _viewModel = ViewModelProvider(
            this,
            TarefaViewModel
                .TarefaViewModelFactory(TarefaRepository(AppDatabase.getDatabase(_view.context).tarefaDao()))
        ).get(TarefaViewModel::class.java)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val manager = LinearLayoutManager(view.context)

        _adapter = TarefaAdapter()

        recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = manager
            adapter = _adapter
        }

        bindEvents()
        initialize()
    }

    private fun initialize() {
        _viewModel.obterTarefas().observe(viewLifecycleOwner, {
            _adapter.adicionarTarefas(it)
        })
    }

    private fun bindEvents() {
        _view.findViewById<Button>(R.id.btnNova).setOnClickListener {
            val edtTarefaView = _view.findViewById<EditText>(R.id.edtTarefa)
            val descricao = edtTarefaView.text.toString()
            edtTarefaView.setText("")

            val params = descricao.split(",")

            if (params.size > 1) {
                _viewModel.atualizarTarefa(params[0].toLong(), params[1]).observe(viewLifecycleOwner, {
                    _adapter.atualizar(TarefaEntity(params[0].toLong(), params[1]))
                })
            } else {
                _viewModel.inserirTarefa(descricao).observe(viewLifecycleOwner, {
                    _adapter.adicionarTarefa(it)
                })
            }
        }
    }
}