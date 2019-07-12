package com.example.theseus.movieapp.data.api

import javax.inject.Inject

class ApiManager @Inject constructor(val moviesDbAPI: MoviesDbAPI) : IApiManager {
    override fun fetchMovieDetail(movieId: String) = moviesDbAPI.getMovieDetail(movieId)

    override fun fetchMoviesFromApi() = moviesDbAPI.getTopRatedMovies()
}