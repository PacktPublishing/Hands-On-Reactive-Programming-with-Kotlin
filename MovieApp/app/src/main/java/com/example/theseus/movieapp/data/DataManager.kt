package com.example.theseus.movieapp.data

import com.example.theseus.movieapp.data.api.IApiManager
import com.example.theseus.movieapp.data.api.model.TopRatedMovieResponse.MovieResponse
import io.reactivex.Single
import javax.inject.Inject

class DataManager @Inject constructor(val mApiManager: IApiManager) : IDataManager {


    override fun fetchMoviesFromAPI(): Single<MovieResponse> {
        return mApiManager.fetchMoviesFromApi()
    }
}