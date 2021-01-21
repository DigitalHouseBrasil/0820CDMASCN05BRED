package com.lucas.moviesapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.lucas.moviesapp.repository.MovieRepository
import com.lucas.moviesapp.viewmodel.MovieViewModel
import com.lucas.moviesapp.viewmodel.MovieViewModelFactory
import com.lucas.moviesapp.R
import com.lucas.moviesapp.data.Result
import com.lucas.moviesapp.view.adapter.UserListAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.Dispatchers

class HomeActivity : AppCompatActivity() {
    private val viewModel: MovieViewModel by lazy {
        val factory = MovieViewModelFactory(
            Dispatchers.IO,
            MovieRepository()
        )
        ViewModelProvider(this, factory).get(MovieViewModel::class.java)
    }

    private val recyclerView: RecyclerView by lazy { findViewById<RecyclerView>(R.id.recyclerview) }
    private val progressBar: ProgressBar by lazy { findViewById<ProgressBar>(R.id.pb_loading) }

    private val adapter: UserListAdapter by lazy {
        UserListAdapter(
            ArrayList()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerview.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.getListUsers()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.stateList.observe(this, Observer { state ->
            state?.let {
                showListUsers(it as MutableList<Result>)
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

    private fun showListUsers(list: MutableList<Result>) {
        adapter.updateList(list)
    }

    private fun showLoading(status: Boolean) {
        when {
            status -> {
                progressBar.visibility = View.VISIBLE
            }
            else -> {
                progressBar.visibility = View.GONE
            }
        }
    }

    private fun showErrorMessage(message: String) {
        Snackbar.make(recyclerView, message, Snackbar.LENGTH_LONG).show()
    }
}