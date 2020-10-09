package com.lucas.interacoes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

const val FAHRENHEIT = "°F"
const val RESULT_EMPTY2 = "Preencha o campo mano"

class Temperatura : AppCompatActivity() {
    private val edInputValue by lazy { findViewById<EditText>(R.id.edtNumeroTemp) }

    private val btnResult by lazy { findViewById<Button>(R.id.btnMostrarResultadoTemp) }

    private val tvResult by lazy { findViewById<TextView>(R.id.txtResultTemp) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperatura)


        btnResult.setOnClickListener {
            if (edInputValue.text.isNotEmpty()) {
                val valorConvertido = edInputValue.text.toString().toFloat()
                ((valorConvertido * 9 / 5) + 32)
                tvResult.visibility = View.VISIBLE
                tvResult.text = ("$edInputValue $FAHRENHEIT")
            } else {
                edInputValue.error = RESULT_EMPTY2
                tvResult.visibility = View.GONE
            }
        }
    }
}
