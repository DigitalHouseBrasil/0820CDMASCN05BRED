package com.turma05.dragdemolab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    val ativos: MutableList<Button> = mutableListOf()
    val todos: MutableList<Button> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populaTodos()
        desenharBotoes()
    }

    private fun populaTodos() {
        for (i in 0..10) {
            val button = Button(this)
            button.setText(i.toString())

            todos.add(button)

            button.setOnClickListener {
                moveParaAtivo(button)
                desenharBotoes()
            }
        }
    }

    private fun moveParaAtivo(button: Button) {
        val indexAtivo = ativos.indexOf(button)
        val indexTodos = todos.indexOf(button)

        if (indexTodos == -1) {
            todos.add(ativos.removeAt(indexAtivo))
        } else {
            if (ativos.size < MAX_ATIVOS) {
                ativos.add(todos.removeAt(indexTodos))
            }
        }
    }

    private fun desenharBotoes() {
        val linearLayoutTodos = findViewById<LinearLayout>(R.id.linearLayoutTodos)
        val linearLayoutAtivos = findViewById<LinearLayout>(R.id.linearLayoutAtivos)

        linearLayoutTodos.removeAllViews()
        linearLayoutAtivos.removeAllViews()

        desenharBotoesTodos()
        desenharBotoesAtivos()
    }

    private fun desenharBotoesTodos() {
        val linearLayoutTodos = findViewById<LinearLayout>(R.id.linearLayoutTodos)

        for (button in todos) {

            linearLayoutTodos.addView(button)
        }
    }

    private fun desenharBotoesAtivos() {
        val linearLayoutAtivos = findViewById<LinearLayout>(R.id.linearLayoutAtivos)

        for (button in ativos) {
            linearLayoutAtivos.addView(button)
        }
    }

    companion object {
        const val MAX_ATIVOS = 2
    }
}