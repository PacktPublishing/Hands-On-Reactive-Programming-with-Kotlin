package com.example.theseus.movieapp.data.db

import com.example.theseus.movieapp.data.db.model.Movie
import com.example.theseus.movieapp.data.db.model.MovieDao
import javax.inject.Inject

class DataBaseManager @Inject constructor(val movieDao: MovieDao):IDataBaseManager {
    override fun deleteAllMovies() {
        movieDao.deleteAllMovies()
    }

    override fun insertMovies(movieList: List<Movie>) {
        movieDao.insertAllMovies(movieList)
    }

}