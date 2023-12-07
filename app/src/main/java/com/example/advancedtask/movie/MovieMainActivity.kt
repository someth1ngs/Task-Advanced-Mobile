package com.example.advancedtask.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.advancedtask.movie.modals.Movie
import com.example.advancedtask.movie.modals.MovieResponse
import com.example.advancedtask.movie.services.MovieApiInterface
import com.example.advancedtask.movie.services.MovieApiService
import com.example.advancedtask.databinding.ActivityMovieMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMovieMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvMoviesList.layoutManager = LinearLayoutManager(this)
        binding.rvMoviesList.setHasFixedSize(true)
        getMovieData { movies: List<Movie> ->
            binding.rvMoviesList.adapter = MovieAdapter(applicationContext, movies)

        }
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}