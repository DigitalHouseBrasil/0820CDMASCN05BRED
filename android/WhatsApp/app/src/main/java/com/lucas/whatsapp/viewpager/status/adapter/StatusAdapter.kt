package com.lucas.whatsapp.viewpager.status.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucas.whatsapp.R
import com.lucas.whatsapp.viewpager.status.Status

class StatusAdapter(private val dataSet: List<Status>) : RecyclerView.Adapter<StatusViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout_status, parent, false)

        return StatusViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: StatusViewHolder, position: Int) =
        holder.bind(dataSet[position])
}