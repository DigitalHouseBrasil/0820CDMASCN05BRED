package com.turma05.whatsappdemo.home.call.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.turma05.whatsappdemo.R
import com.turma05.whatsappdemo.model.CharacterModel

class CharacterAdapter(private val dataSet: List<CharacterModel>) :
    RecyclerView.Adapter<CharacterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_calls_layout, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }


}