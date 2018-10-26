package com.example.theseus.movieapp.data

import com.example.theseus.movieapp.data.api.model.TopRatedMovieResponse.MovieResponse
import io.reactivex.Single

interface IDataManager {
    // movie ops
    fun fetchMoviesFromAPI(): Single<MovieResponse>
}