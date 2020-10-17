package com.digitalhouse.aula21_comunicacaofragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_meu.view.*
import java.time.Year
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [MeuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MeuFragment : Fragment() {

    lateinit var iClicou: IClicou

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_meu, container, false)

        view.btnClica.setOnClickListener {
            iClicou.clicou("Clicou mesmo!")
        }

        val anoAtual = Calendar.getInstance().get(Calendar.YEAR)

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        iClicou = context as IClicou
    }
}