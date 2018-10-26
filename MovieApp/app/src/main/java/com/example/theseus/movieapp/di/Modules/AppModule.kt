package com.example.theseus.movieapp.di.Modules

import android.app.Application
import com.example.theseus.movieapp.data.DataManager
import com.example.theseus.movieapp.data.IDataManager
import com.example.theseus.movieapp.data.api.ApiManager
import com.example.theseus.movieapp.data.api.IApiManager
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

}