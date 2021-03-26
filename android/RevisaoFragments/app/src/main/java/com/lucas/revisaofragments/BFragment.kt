package com.lucas.revisaofragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_b.*


class BFragment : Fragment() {
    private lateinit var  fragmentBView : View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentBView  = inflater.inflate(R.layout.fragment_b, container, false)

        return fragmentBView

    }

    //funcionalidade para alterar o texto da view no fragment
    fun changeText(text : String){
        tvFragmentB.text = text
    }
}