package com.turma05.aula40.tarefa.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.turma05.aula40.R
import com.turma05.aula40.tarefa.entity.TarefaEntity

class TarefaViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    private val descricaoTarefa = view.findViewById<TextView>(R.id.txtTarefa)
    private val idTarefa = view.findViewById<TextView>(R.id.txtId)

    fun bind(tarefa: TarefaEntity) {
        descricaoTarefa.text = tarefa.descricao
        idTarefa.text = tarefa.id.toString()
    }
}