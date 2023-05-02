package com.axellinoanggoro.binar_tmdb_api.model


import com.google.gson.annotations.SerializedName

data class ResponseGetTrendingMovie<T>(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<ResultItem>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)