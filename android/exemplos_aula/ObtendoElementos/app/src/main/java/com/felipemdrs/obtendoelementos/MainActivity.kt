package com.felipemdrs.obtendoelementos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMostrarResultado.setOnClickListener {
            val numero = edtNumero.text.toString().toInt()

            if (ehPar(numero)) {
                txtResult.text = getString(R.string.mensagem_par, numero)
            } else {
                txtResult.text = getString(R.string.mensagem_impar, numero.toFloat())
            }
        }
    }

    fun ehPar(num: Int): Boolean {
        return num % 2 == 0
    }
}