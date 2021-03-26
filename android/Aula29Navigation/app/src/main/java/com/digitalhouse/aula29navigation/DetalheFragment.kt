package com.digitalhouse.aula29navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.Navigation

// TODO: Rename parameter arguments, choose names that match

class DetalheFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalhe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.button2).setOnClickListener {
            val bundle = bundleOf(KEY_NOME to "Andre", KEY_IMAGE to R.drawable.louro)

            navController.navigate(R.id.segundoFragment, bundle)
        }
    }

    companion object {
        const val KEY_NOME = "NOME"
        const val KEY_IMAGE = "IMAGE"
    }
}