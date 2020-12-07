package com.turma05.aula40

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.turma05.aula40.tarefa.view.TarefaFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, TarefaFragment())
            .commit()
    }
}