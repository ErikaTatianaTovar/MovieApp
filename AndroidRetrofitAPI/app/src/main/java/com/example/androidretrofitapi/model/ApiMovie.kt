package com.example.androidretrofitapi.model

import retrofit2.Call
import retrofit2.http.GET

interface ApiMovie {
    @GET("movies/cover")
    fun getMovies(): Call<List<Movie>>
}