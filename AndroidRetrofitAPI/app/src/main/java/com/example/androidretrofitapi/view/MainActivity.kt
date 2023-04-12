package com.example.androidretrofitapi.view

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.androidretrofitapi.model.Movie
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidretrofitapi.R
import com.example.androidretrofitapi.model.ApiClient
import com.example.androidretrofitapi.model.ApiMovie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var movies: List<Movie>? = null
    private lateinit var recyclerView: RecyclerView
    private var movieAdapter: MovieAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rv_movies)
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
        showMovies()
    }

    private fun showMovies() {
        val call: Call<List<Movie>> = ApiClient.getClient().create(ApiMovie::class.java).getMovies()
        call.enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                if (response.isSuccessful) {
                    movies = response.body()
                    val movieAdapter = MovieAdapter(movies, applicationContext)
                    recyclerView.adapter = movieAdapter
                }
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                val messageError = applicationContext.getString(R.string.connection_error)
                Toast.makeText(this@MainActivity, messageError, Toast.LENGTH_SHORT).show()
            }
        })
    }
}