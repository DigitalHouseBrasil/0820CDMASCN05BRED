package com.turma05.aula40.tarefa.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.turma05.aula40.R
import com.turma05.aula40.tarefa.entity.TarefaEntity

class TarefaAdapter: RecyclerView.Adapter<TarefaViewHolder>() {
    private val _tarefas: MutableList<TarefaEntity> = mutableListOf()

    fun adicionarTarefa(tarefa: TarefaEntity) {
        _tarefas.add(tarefa)
        notifyDataSetChanged()
    }

    fun adicionarTarefas(tarefas: List<TarefaEntity>) {
        _tarefas.addAll(tarefas)
        notifyDataSetChanged()
    }

    fun atualizar(tarefaEntity: TarefaEntity) {
        for (tarefa in _tarefas) {
            if (tarefa.id == tarefaEntity.id) {
                tarefa.descricao = tarefaEntity.descricao
                break
            }
        }

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_list_item, parent, false)
        return TarefaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val item = _tarefas[position]
        holder.bind(item)
    }

    override fun getItemCount() = _tarefas.size
}