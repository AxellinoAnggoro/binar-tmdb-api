package com.axellinoanggoro.binar_tmdb_api.network

import com.axellinoanggoro.binar_tmdb_api.model.ResponseGetTrendingMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestfulApi {
    @GET("trending/movie/week")
    fun getWeeklyTrendingMovie(
        @Query("api_key") API_KEY: String,
        @Query("page") PAGE: Int
    ): Call<ResponseGetTrendingMovie<com.axellinoanggoro.binar_tmdb_api.model.ResultItem>>
}