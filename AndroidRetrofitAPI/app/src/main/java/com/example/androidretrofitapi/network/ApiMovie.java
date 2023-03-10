package com.example.androidretrofitapi.network;

import com.example.androidretrofitapi.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiMovie {
    @GET("movies/cover")
    Call<List<Movie>> getMovies();
}
