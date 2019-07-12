package com.example.theseus.movieapp.data.api

import com.example.theseus.movieapp.data.api.model.MovieDetailResponse.MovieDetailResponse
import com.example.theseus.movieapp.data.api.model.TopRatedMovieResponse.MovieResponse
import io.reactivex.Single

interface IApiManager {
    fun fetchMoviesFromApi(): Single<MovieResponse>
    fun fetchMovieDetail(movieId: String): Single<MovieDetailResponse>
}