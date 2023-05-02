//package com.axellinoanggoro.binar_tmdb_api.viewmodel
//
//import androidx.lifecycle.MutableLiveData
//import com.axellinoanggoro.binar_tmdb_api.model.Result
//import com.axellinoanggoro.binar_tmdb_api.network.RetrofitClient
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.Retrofit
//
//class MovieViewModel {
//    var getDataMovie : MutableLiveData<List<com.axellinoanggoro.binar_tmdb_api.model.Result>> = MutableLiveData()
//    val listMovie = mutableListOf<com.axellinoanggoro.binar_tmdb_api.model.Result>()
//
//    fun callTmdbApi(){
//        RetrofitClient.instance.getWeeklyTrendingMovie(API_KEY = "3cf1453ff43199b0e878a7e9f7614476", PAGE = 1).enqueue(object : Callback<List<com.axellinoanggoro.binar_tmdb_api.model.Result>>{
//            override fun onResponse(call: Call<List<Result>>, response: Response<List<Result>>) {
//                if (response.isSuccessful){
//                    getDataMovie.postValue(response.body())
//                }else{
//                    getDataMovie.postValue(null)
//                }
//            }
//
//            override fun onFailure(call: Call<List<Result>>, t: Throwable) {
//                getDataMovie.postValue(null)
//            }
//
//        })
//    }
//}