package com.example.theseus.movieapp

import android.app.Application
import com.example.theseus.movieapp.di.Components.AppComponent
import com.example.theseus.movieapp.di.Components.DaggerAppComponent
import com.example.theseus.movieapp.di.Modules.AppModule

open class MovieApplication : Application() {
    lateinit var movieComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        movieComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
//        Stetho.initializeWithDefaults(this)
    }
}