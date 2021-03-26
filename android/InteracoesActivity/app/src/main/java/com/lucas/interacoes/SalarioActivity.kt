package com.lucas.interacoes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

const val CIFRAO = "R$"
const val RESULT_EMPTY3 = "Coloca um nome ai tiw"

class SalarioActivity : AppCompatActivity() {


    private val edHorasTrabalhadas by lazy { findViewById<EditText>(R.id.edtHorasTrabalho) }
    private val edValorHora by lazy { findViewById<EditText>(R.id.edtNumeroTrabalho) }

    private val btnResult by lazy { findViewById<Button>(R.id.btnMostrarResultadoTrabalho) }
    //private val btnRestart by lazy { findViewById<Button>(R.id.btnRestart) }

    private val tvResult by lazy { findViewById<TextView>(R.id.txtResultTrabalho) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salario)


        btnResult.setOnClickListener {

            if (edHorasTrabalhadas.text.isNotEmpty() || edValorHora.text.isNotEmpty()) {
                val converteHorasTrabalhadas = edHorasTrabalhadas.text.toString().toFloat()
                val converteValorHora = edValorHora.text.toString().toFloat()
                tvResult.visibility = View.VISIBLE
                tvResult.text = (CIFRAO + converteHorasTrabalhadas * converteValorHora)
            } else {
                edHorasTrabalhadas.error = RESULT_EMPTY3
                edValorHora.error = RESULT_EMPTY3
                tvResult.visibility = View.GONE
            }
        }
    }
}
