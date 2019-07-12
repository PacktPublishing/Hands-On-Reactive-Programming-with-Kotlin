package com.example.theseus.movieapp.di.Modules

import com.example.theseus.movieapp.data.api.MoviesDbAPI
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor




@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor(logging) // <-- this is the important line!
        var ret = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return (ret)
    }

    @Provides
    @Singleton
    fun provideTheMovieDBApi(retrofit: Retrofit) = retrofit.create(MoviesDbAPI::class.java)
}