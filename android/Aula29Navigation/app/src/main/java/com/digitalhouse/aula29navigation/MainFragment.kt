package com.digitalhouse.aula29navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.Navigation

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.button).setOnClickListener {
            navController.navigate(R.id.detalheFragment)
        }

        view.findViewById<Button>(R.id.button3).setOnClickListener {
            val bundle = bundleOf("ANIMAL" to "PAPAGAIO")

            navController.navigate(R.id.testeActivity, bundle)
        }
    }
}