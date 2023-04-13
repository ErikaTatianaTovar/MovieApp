package com.example.androidretrofitapi.model.api

import com.example.androidretrofitapi.model.vo.Movie
import retrofit2.Call
import retrofit2.http.GET

interface ApiMovie {
    @GET("movies/cover")
    fun getMovies(): Call<List<Movie>>
}