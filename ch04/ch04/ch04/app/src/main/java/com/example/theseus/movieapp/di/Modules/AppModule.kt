package com.example.theseus.movieapp.di.Modules

import android.app.Application
import com.example.theseus.movieapp.data.DataManager
import com.example.theseus.movieapp.data.IDataManager
import com.example.theseus.movieapp.data.api.ApiManager
import com.example.theseus.movieapp.data.api.IApiManager
import com.example.theseus.movieapp.data.db.DataBaseManager
import com.example.theseus.movieapp.data.db.IDataBaseManager
import com.example.theseus.movieapp.data.db.MovieDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: Application) {

    @Provides
    @Singleton
    fun provideDataManager(mDataManager: DataManager): IDataManager = mDataManager

    @Provides
    @Singleton
    fun provideApiManager(mApiManager: ApiManager) = mApiManager as IApiManager

    @Provides
    @Singleton
    fun provideDatabaseManager(mDatabaseManager: DataBaseManager) = mDatabaseManager as IDataBaseManager

    @Provides
    @Singleton
    fun provideMovieDao(movieDatabase: MovieDatabase) = movieDatabase.movieDAO()

    @Provides
    @Singleton
    fun provideMovieDatabase() = MovieDatabase.getInstance(app)

}