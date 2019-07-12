package com.example.theseus.movieapp.data

import com.example.theseus.movieapp.data.api.model.TopRatedMovieResponse.MovieResponse
import com.example.theseus.movieapp.data.db.model.Movie
import io.reactivex.Single

interface IDataManager {
    // movie ops
    fun fetchMoviesFromAPI(): Single<MovieResponse>

    fun saveMoviesInDatabase(movieList: List<Movie>)
    fun clearMoviesFromDatabase()
}