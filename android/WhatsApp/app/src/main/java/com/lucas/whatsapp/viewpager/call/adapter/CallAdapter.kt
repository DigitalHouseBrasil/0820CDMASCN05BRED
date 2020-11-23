package com.lucas.whatsapp.viewpager.call.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucas.whatsapp.R
import com.lucas.whatsapp.viewpager.call.Call

class CallAdapter(private val dataSet: List<Call>) : RecyclerView.Adapter<CallViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_call, parent, false)
        return CallViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: CallViewHolder, position: Int) =
        holder.bind(dataSet[position])
}