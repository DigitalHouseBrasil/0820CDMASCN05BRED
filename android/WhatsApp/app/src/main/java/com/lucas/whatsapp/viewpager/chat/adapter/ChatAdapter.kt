package com.lucas.whatsapp.viewpager.chat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucas.whatsapp.R
import com.lucas.whatsapp.model.CharacterModel

class ChatAdapter(private val dataSet: List<CharacterModel>) : RecyclerView.Adapter<ChatViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout_message, parent, false)

        return ChatViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) =
        holder.bind(dataSet[position])

}