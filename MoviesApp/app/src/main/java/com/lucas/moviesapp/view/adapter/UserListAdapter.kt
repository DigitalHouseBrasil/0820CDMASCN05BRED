package com.lucas.moviesapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucas.moviesapp.R
import com.lucas.moviesapp.data.Result
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.itemmovie_layout.view.*

const val BASE_URL = "https://image.tmdb.org/t/p/w185/"

class UserListAdapter(var users: List<Result>) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemmovie_layout, parent, false)
        return ViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(users[position])

    override fun getItemCount(): Int = users.size

    fun updateList(users: MutableList<Result>) {
        this.users = users
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(movie: Result) {
            itemView.titleNameMovie.text = movie.title
            itemView.PreviDescriptionMovie.text = movie.overview
            
            Picasso.get()
                .load(BASE_URL + movie.poster_path)
                .error(R.drawable.ic_round_account_circle)
                .into(itemView.imagemovieName)
        }
    }
}