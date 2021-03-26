package com.digitalhouse.aulaviewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 * Use the [MeuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MeuFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString("TEXTO")
            param2 = it.getBoolean("EH_MAIOR_DE_IDADE")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val minhaView = inflater.inflate(R.layout.fragment_meu, container, false)

        minhaView.findViewById<TextView>(R.id.txtMeuTexto).text = param1
        
        return minhaView
    }

    companion object {
        fun newInstance(texto: String, ehMaiorDeIdade: Boolean) =
            MeuFragment().apply {
                arguments = Bundle().apply {
                    putString("TEXTO", texto)
                    putBoolean("EH_MAIOR_DE_IDADE", ehMaiorDeIdade)
                }
            }
    }
}