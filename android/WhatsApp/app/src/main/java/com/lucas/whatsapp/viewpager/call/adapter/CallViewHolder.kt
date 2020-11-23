package com.lucas.whatsapp.viewpager.call.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lucas.whatsapp.R
import com.lucas.whatsapp.viewpager.call.Call

class CallViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var imgCall = itemView.findViewById<ImageView>(R.id.imgCall)
    private var nameCall = itemView.findViewById<TextView>(R.id.txtCallName)
    private var dateCall = itemView.findViewById<TextView>(R.id.txtCallDate)

    fun bind(call: Call) {
        imgCall.setImageResource(call.imageSrc)
        nameCall.text = call.name
        dateCall.text = call.date
    }
}
