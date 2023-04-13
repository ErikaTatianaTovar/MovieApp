package com.example.androidretrofitapi.model

import com.example.androidretrofitapi.model.api.ApiClient
import com.example.androidretrofitapi.model.api.ApiMovie
import com.example.androidretrofitapi.model.vo.Movie
import com.example.androidretrofitapi.presenter.MoviePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieRepositoryImpl(var moviePresenter: MoviePresenter) : MovieRepository {

    override fun getMoviesAPI() {
        val call: Call<List<Movie>> = ApiClient.getClient().create(ApiMovie::class.java).getMovies()
        call.enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                if (response.isSuccessful) {
                    response.body()?.let { movies ->
                        moviePresenter.setMovies(movies)
                    }
                }
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                moviePresenter.sendError("error")
            }
        })
    }
}