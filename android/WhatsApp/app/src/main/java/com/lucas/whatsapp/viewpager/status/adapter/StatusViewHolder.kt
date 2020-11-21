package com.lucas.whatsapp.viewpager.status.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lucas.whatsapp.R
import com.lucas.whatsapp.viewpager.status.Status

class StatusViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var ivStatus = itemView.findViewById<ImageView>(R.id.imgStatus)
    private var tvNameStatus = itemView.findViewById<TextView>(R.id.tvStatusName)
    private var tvDateStatus = itemView.findViewById<TextView>(R.id.tvStatusDate)

    fun bind(status: Status) {
        ivStatus.setImageResource(status.imageSrc)
        tvNameStatus.text = status.name
        tvDateStatus.text = status.date
    }
}
