package com.lucas.interacoes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_meu_nome.*


const val MEU_NOME = "Meu nome é "
const val RESULT_EMPTY = "Coloca um nome ai tiw"

class MeuNome : AppCompatActivity() {

    //forma 1 de inicializacao = usando o by lazy { } para instanciar e inicializar a view com o findview
    private val btnResult by lazy { findViewById<Button>(R.id.btnMostrarResultado) }
    private val btnRestart by lazy { findViewById<Button>(R.id.btnRestart) }

    private val tvResult by lazy { findViewById<TextView>(R.id.txtResult) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meu_nome)


        btnResult.setOnClickListener {
            //forma 2 de inicialização = usando a lib do synthetic para chamar a view através do id
            val resultName = edtNumero.text.toString()

            if (resultName.isNotEmpty()) {
                tvResult.visibility = View.VISIBLE
                tvResult.text = ("$MEU_NOME $resultName")
            }
            else {
                edtNumero.error = RESULT_EMPTY
                tvResult.visibility = View.GONE
            }
        }

        btnRestart.setOnClickListener {
            tvResult.visibility = View.GONE
        }
    }
}