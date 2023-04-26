package com.example.androidretrofitapi.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.androidretrofitapi.model.api.ApiClient
import com.example.androidretrofitapi.model.api.ApiMovie
import com.example.androidretrofitapi.model.vo.Movies
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieRepositoryImpl : MovieRepository {

    private var moviesMutable = MutableLiveData<List<Movies>>()

    //lógica de conexión
    override fun callMoviesAPI() {
        val call: Call<List<Movies>> =
            ApiClient.getClient().create(ApiMovie::class.java).getMovies()

        call.enqueue(object : Callback<List<Movies>> {
            override fun onResponse(call: Call<List<Movies>>, response: Response<List<Movies>>) {
                if (response.isSuccessful) {
                    response.body()?.let { movies ->
                        moviesMutable.value = movies
                    }
                }
            }

            override fun onFailure(call: Call<List<Movies>>, t: Throwable) {
                Log.e("Error:", t.message ?: "error")
                t.stackTrace
            }
        })
    }
    override fun getMovies(): MutableLiveData<List<Movies>> {
        return moviesMutable
    }
}