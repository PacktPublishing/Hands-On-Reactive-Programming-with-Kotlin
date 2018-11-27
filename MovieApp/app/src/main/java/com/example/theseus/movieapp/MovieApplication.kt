package com.example.theseus.movieapp

import android.app.Application
import com.example.theseus.movieapp.di.Components.AppComponent
import com.example.theseus.movieapp.di.Components.DaggerAppComponent
import com.example.theseus.movieapp.di.Modules.AppModule
import com.facebook.stetho.Stetho

open class MovieApplication : Application() {
    lateinit var movieComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        movieComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
//        Stetho.initializeWithDefaults(this)
    }
}