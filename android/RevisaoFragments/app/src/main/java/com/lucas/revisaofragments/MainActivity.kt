package com.lucas.revisaofragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), IClick {

    //instancio meus fragments
    private val fragmentA = AFragment()
    private val fragmentB = BFragment()

    //atribuo meu supportManager para a variavel manager
    private val manager = supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //passo para minha função o id do meu container e meu fragment inicializado
        addFragment(fragmentA, R.id.fragmentContainerA)
        addFragment(fragmentB, R.id.fragmentContainerB)

    }

    override fun click(name: String, birthYear: Int) {
        //ano atual
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)

        if (currentYear.compareTo(birthYear) < 0) {
            fragmentB.changeText(" $name ainda não nasceu")
        } else {
            //subtração do ano atual com o ano de nascimento, atribuido numa varivel
            val age = currentYear.minus(birthYear)
            fragmentB.changeText("$name, você tem $age anos")
        }
    }


    //função que chama o fragment e adiciona no nosso container da Activity
    private fun addFragment(fragment: Fragment, container: Int) {
        val transaction = manager.beginTransaction()
        transaction.add(container, fragment)
        transaction.commit()
    }

}