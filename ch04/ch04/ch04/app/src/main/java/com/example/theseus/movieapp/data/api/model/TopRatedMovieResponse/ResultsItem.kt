package com.example.theseus.movieapp.data.api.model.TopRatedMovieResponse

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class ResultsItem(

@field:SerializedName("overview")
val overview: String? = null,

@field:SerializedName("original_language")
val originalLanguage: String? = null,

@field:SerializedName("original_title")
val originalTitle: String? = null,

@field:SerializedName("video")
val video: Boolean? = null,

@field:SerializedName("title")
val title: String,

@field:SerializedName("genre_ids")
val genreIds: List<Int?>? = null,

@field:SerializedName("poster_path")
val posterPath: String,

@field:SerializedName("backdrop_path")
val backdropPath: String? = null,

@field:SerializedName("release_date")
val releaseDate: String? = null,

@field:SerializedName("popularity")
val popularity: Double? = null,

@field:SerializedName("vote_average")
val voteAverage: Double? = null,

@field:SerializedName("id")
val id: Int,

@field:SerializedName("adult")
val adult: Boolean? = null,

@field:SerializedName("vote_count")
val voteCount: Int? = null
)