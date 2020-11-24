package com.turma05.whatsappdemo.home.call.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.turma05.whatsappdemo.R
import com.turma05.whatsappdemo.model.CharacterModel

class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var ivCharacter = itemView.findViewById<ImageView>(R.id.imgCall)
    private var tvName = itemView.findViewById<TextView>(R.id.txtCallName)
    private var tvMessage = itemView.findViewById<TextView>(R.id.txtCallMessage)

    fun bind(character: CharacterModel) {

        tvName.text = character.name
        tvMessage.text = character.nickname

        Picasso.get()
            .load(character.img)
            .into(ivCharacter)
    }
}
