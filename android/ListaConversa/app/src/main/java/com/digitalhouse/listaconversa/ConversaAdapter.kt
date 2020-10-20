package com.digitalhouse.listaconversa

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ConversaAdapter(private val conversas: List<Conversa>): RecyclerView.Adapter<ConversaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConversaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.conversa_item, parent, false)

        return ConversaViewHolder(view)
    }

    override fun getItemCount() = conversas.size

    override fun onBindViewHolder(holder: ConversaViewHolder, position: Int) {
        holder.bind(conversas[position])
    }
}