package com.axellinoanggoro.binar_tmdb_api.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.axellinoanggoro.binar_tmdb_api.databinding.ItemMovieBinding
import com.bumptech.glide.Glide

class MovieAdapter(var listMovie : List<com.axellinoanggoro.binar_tmdb_api.model.ResultItem>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    class ViewHolder(var binding : ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        var view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.binding.titleMovie.text = listMovie[position].originalTitle
        holder.binding.dateMovie.text = listMovie[position].releaseDate
        holder.binding.dscMovie.text = listMovie[position].overview
        Glide.with(holder.itemView).load("https://image.tmdb.org/t/p/w500${listMovie[position].posterPath}").into(holder.binding.imgMovie)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }
}