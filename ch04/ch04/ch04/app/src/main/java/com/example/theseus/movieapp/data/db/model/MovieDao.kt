package com.example.theseus.movieapp.data.db.model

import android.arch.persistence.room.*

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAllMovies(movie: List<Movie>)

    @Query("DELETE from Movie")
    abstract fun deleteAllMovies()
}