package com.axellinoanggoro.binar_tmdb_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.axellinoanggoro.binar_tmdb_api.adapter.MovieAdapter
import com.axellinoanggoro.binar_tmdb_api.databinding.ActivityMainBinding
import com.axellinoanggoro.binar_tmdb_api.model.ResponseGetTrendingMovie
import com.axellinoanggoro.binar_tmdb_api.model.ResultItem
import com.axellinoanggoro.binar_tmdb_api.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val listMovie = mutableListOf<com.axellinoanggoro.binar_tmdb_api.model.ResultItem>()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        getDataMovie()
    }

    fun getDataMovie(){
        RetrofitClient.instance.getWeeklyTrendingMovie(API_KEY = "3cf1453ff43199b0e878a7e9f7614476", PAGE = 1).enqueue(object : Callback<ResponseGetTrendingMovie<com.axellinoanggoro.binar_tmdb_api.model.ResultItem>>{
            override fun onResponse(
                call: Call<ResponseGetTrendingMovie<ResultItem>>,
                response: Response<ResponseGetTrendingMovie<ResultItem>>
            ) {
                if (response.isSuccessful){
                    binding.rvMovie.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    val movieRes = response.body()
                    if (movieRes != null){
                        listMovie.addAll(movieRes.results)
                        binding.rvMovie.adapter = MovieAdapter(listMovie)
                    }else{
                        Toast.makeText(this@MainActivity, "Failed to load data", Toast.LENGTH_SHORT)
                            .show()
                    }

                }
            }

            override fun onFailure(call: Call<ResponseGetTrendingMovie<ResultItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed to load data", Toast.LENGTH_SHORT)
                    .show()
            }

        })
    }
}