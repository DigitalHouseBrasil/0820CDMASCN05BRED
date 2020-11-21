package com.lucas.whatsapp.viewpager.call

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucas.whatsapp.R
import com.lucas.whatsapp.viewpager.call.adapter.CallAdapter


class CallFragment : Fragment() {

    private lateinit var callView: View
    private lateinit var recyclerView: RecyclerView

    private val callDataSet = arrayListOf(
        Call(R.drawable.maebrava, "Mãe", "Now"),
        Call(
            R.drawable.maebrava,
            "Mãe",
            "10 minutes ago"
        ),
        Call(
            R.drawable.maebrava,
            "Mãe",
            "12 minutes ago"
        ),
        Call(
            R.drawable.maebrava,
            "Mãe",
            "13 minutes ago"
        ),
        Call(
            R.drawable.paimuquirana,
            "Pai",
            "25 minutes ago"
        ),
        Call(
            R.drawable.chefebravo,
            "Chefe",
            "1h hours ago"
        ),
        Call(
            R.drawable.amigobebado,
            "Bebasso",
            "4h hours ago"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        callView = inflater.inflate(R.layout.fragment_call, container, false)
        return callView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView = callView.findViewById(R.id.rv_calls)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = CallAdapter(callDataSet)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }
}