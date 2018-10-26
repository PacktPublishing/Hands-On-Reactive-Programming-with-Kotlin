package com.example.theseus.movieapp.data.api

import com.example.theseus.movieapp.BuildConfig
import com.example.theseus.movieapp.data.api.model.MovieDetailResponse.MovieDetailResponse
import com.example.theseus.movieapp.data.api.model.TopRatedMovieResponse.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesDbAPI {

    @GET("top_rated?api_key=${BuildConfig.API_KEY}&language=en-US")
    fun getTopRatedMovies(): Single<MovieResponse>

    @GET("{movie_id}?api_key=${BuildConfig.API_KEY}")
    fun getMovieDetail(@Path("movie_id") movie_id: String): Single<MovieDetailResponse>
}