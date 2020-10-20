package com.digitalhouse.listaconversa

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ConversaViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val textoNome: TextView = view.findViewById(R.id.txtNome)
    private val textoConversa: TextView = view.findViewById(R.id.txtConversa)
    private val textoHora: TextView = view.findViewById(R.id.txtHora)

    fun bind(conversa: Conversa) {
        textoNome.text = conversa.nome
        textoConversa.text = conversa.ultima
        textoHora.text = conversa.horario
    }
}