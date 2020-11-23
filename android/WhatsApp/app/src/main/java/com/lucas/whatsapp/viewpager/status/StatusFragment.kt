package com.lucas.whatsapp.viewpager.status

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucas.whatsapp.R
import com.lucas.whatsapp.viewpager.status.adapter.StatusAdapter

class StatusFragment : Fragment() {

    private lateinit var statusView: View
    private lateinit var recyclerView: RecyclerView


    private val statusDataSet = arrayListOf(
        Status(
            R.drawable.paimuquirana,
            "Mãe",
            "15 minutes ago"
        ),
        Status(
            R.drawable.maebrava,
            "Pai",
            "45 minutes ago"
        ),
        Status(
            R.drawable.eu,
            "Bebasso",
            "Today, 8:10 AM"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        statusView = inflater.inflate(R.layout.fragment_status, container, false)
        return statusView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = statusView.findViewById(R.id.rv_status)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = StatusAdapter(statusDataSet)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }

}
