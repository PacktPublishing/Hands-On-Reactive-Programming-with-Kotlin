package com.example.theseus.movieapp.data

import com.example.theseus.movieapp.data.api.IApiManager
import com.example.theseus.movieapp.data.api.model.TopRatedMovieResponse.MovieResponse
import com.example.theseus.movieapp.data.db.IDataBaseManager
import com.example.theseus.movieapp.data.db.model.Movie
import io.reactivex.Single
import javax.inject.Inject

class DataManager @Inject constructor(val mApiManager: IApiManager, val mDatabaseManager: IDataBaseManager) : IDataManager {
    override fun clearMoviesFromDatabase() {
        mDatabaseManager.deleteAllMovies()
    }

    override fun saveMoviesInDatabase(movieList: List<Movie>) {
        mDatabaseManager.insertMovies(movieList)
    }


    override fun fetchMoviesFromAPI(): Single<MovieResponse> {
        return mApiManager.fetchMoviesFromApi()
    }
}