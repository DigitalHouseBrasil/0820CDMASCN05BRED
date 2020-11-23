package com.lucas.whatsapp.viewpager.chat.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lucas.whatsapp.R
import com.lucas.whatsapp.model.CharacterModel
import com.squareup.picasso.Picasso

class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private var ivChat = itemView.findViewById<ImageView>(R.id.ivMessage)
    private var tvName = itemView.findViewById<TextView>(R.id.tvMessageName)
    private var tvMessage = itemView.findViewById<TextView>(R.id.tvMessage)
    private var tvDate = itemView.findViewById<TextView>(R.id.tvDate)

    fun bind(character: CharacterModel) {
        tvName.text = character.name
        tvMessage.text = character.nickname
        tvDate.text = character.birthday

        Picasso.get()
            .load(character.img)
            .into(ivChat)
    }
}
