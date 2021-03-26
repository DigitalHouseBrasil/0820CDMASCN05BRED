package com.lucas.revisaofragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_a.view.*


class AFragment : Fragment() {

    private lateinit var iClick: IClick

    //função inicializada antes do oncreateview e fazendo um cast com o contexto e a interface de click
    override fun onAttach(context: Context) {
        super.onAttach(context)
        iClick = context as IClick
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        calcula(view)
        return view

    }

    private fun calcula(view: View) {

        view.btnCalcula.setOnClickListener {
            //var success = true

            //resgato o valor e atribuo para uma variavel
            val name = view.tvName.editText?.text.toString()
            if (name.isEmpty()){
                view.tvName.editText?.error = "Campo Vazio"
            }

            //resgato o valor e atribuo para uma variavel
            val yearString = view.tvYear.editText?.text.toString()
            if (yearString.isEmpty()){
                view.tvYear.editText?.error = "Campo Vazio"
            }

            //conversao de string para int
            val year = yearString.toInt()

            //resgato o valor que foi passado no parametro
            iClick.click(name, year)

        }
    }

}