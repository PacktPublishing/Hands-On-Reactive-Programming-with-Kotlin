package com.example.theseus.movieapp.data.db

import com.example.theseus.movieapp.data.db.model.Movie

interface IDataBaseManager {
    fun insertMovies(movieList: List<Movie>)
    fun deleteAllMovies()
}