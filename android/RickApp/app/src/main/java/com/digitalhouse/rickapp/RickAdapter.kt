package com.digitalhouse.rickapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.api.Personagem

class RickAdapter(private val personagens: List<Personagem>) :
    RecyclerView.Adapter<RickViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)

        return RickViewHolder(view)
    }

    override fun getItemCount() = personagens.size

    override fun onBindViewHolder(holder: RickViewHolder, position: Int) {
        holder.bind(personagens[position])
    }
}