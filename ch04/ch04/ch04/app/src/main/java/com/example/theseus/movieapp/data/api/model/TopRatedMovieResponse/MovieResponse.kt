package com.example.theseus.movieapp.data.api.model.TopRatedMovieResponse

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class MovieResponse(

    @field:SerializedName("page")
val page: Int? = null,

    @field:SerializedName("total_pages")
val totalPages: Int? = null,

    @field:SerializedName("results")
val results: List<ResultsItem>,

    @field:SerializedName("total_results")
val totalResults: Int? = null
)