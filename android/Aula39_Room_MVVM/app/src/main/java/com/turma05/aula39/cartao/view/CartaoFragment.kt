package com.turma05.aula39.cartao.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.turma05.aula39.R
import com.turma05.aula39.cartao.entity.CartaoEntity
import com.turma05.aula39.cartao.repository.CartaoRepository
import com.turma05.aula39.cartao.viewmodel.CartaoViewModel
import com.turma05.aula39.db.AppDatabase

class CartaoFragment : Fragment() {
    lateinit var _viewModel: CartaoViewModel
    lateinit var _view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cartao, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view

        _viewModel = ViewModelProvider(
            this,
            CartaoViewModel
                .CartaoViewModelFacytory(CartaoRepository(AppDatabase.getDatabase(view.context).cartaoDao()))
        ).get(CartaoViewModel::class.java)

        cadastrarCartao(CartaoEntity(0, "0000111122223333", "Roberto", "123", "10/10", "master"))
        cadastrarCartao(CartaoEntity(0, "1000111122223333", "Roberto", "123", "10/10", "master"))
        cadastrarCartao(CartaoEntity(0, "2000111122223333", "Roberto", "123", "10/10", "master"))
        cadastrarCartao(CartaoEntity(0, "3000111122223333", "Roberto", "123", "10/10", "master"))
    }

    fun cadastrarCartao(cartaoEntity: CartaoEntity) {
        _viewModel.addCartao(
            CartaoEntity(0, "0000111122223333", "Roberto", "123", "10/10", "master")
        )
    }
}