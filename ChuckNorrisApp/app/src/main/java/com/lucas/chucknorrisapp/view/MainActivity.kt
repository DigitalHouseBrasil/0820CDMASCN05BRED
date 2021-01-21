package com.picpay.desafio.android.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.picpay.desafio.android.PicPayRepository
import com.picpay.desafio.android.R
import com.picpay.desafio.android.model.User
import com.picpay.desafio.android.view.adapter.UserListAdapter
import com.picpay.desafio.android.viewmodel.MainViewModel
import com.picpay.desafio.android.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy {
        val factory = MainViewModelFactory(Dispatchers.IO, PicPayRepository())
        ViewModelProvider(this, factory).get(MainViewModel::class.java)
    }

    private val adapter: UserListAdapter by lazy {
        UserListAdapter(
            ArrayList()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.getListUsers()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.stateList.observe(this, Observer { state ->
            state?.let {
                showListUsers(it as MutableList<User>)
            }
        })

        viewModel.loading.observe(this, Observer { loading ->
            loading?.let {
                showLoading(it)
            }
        })

        viewModel.error.observe(this, Observer { loading ->
            loading?.let {
                showErrorMessage(it)
            }
        })
    }

    private fun showListUsers(list: MutableList<User>) {
        adapter.updateList(list)
    }

    private fun showLoading(status: Boolean) {
        when {
            status -> {
                user_list_progress_bar.visibility = View.VISIBLE
            }
            else -> {
                user_list_progress_bar.visibility = View.GONE
            }
        }
    }

    private fun showErrorMessage(message: String) {
        Snackbar.make(recyclerView, message, Snackbar.LENGTH_LONG).show()
    }
}
