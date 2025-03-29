package com.android.ibotestapptemplate.model

data class MovieListResponse(
    val movies: List<MovieResponse>
)

data class MovieResponse(
    val title: String,
    val type: String,
    val titlereleased: String,
    val image_landscape: String,
    val image_portrait: String,
    val rating: String,
    val description: String,
    val quality: String,
    val actors: String,
    val director: String,
    val imdb: String,
    val date_released: String,
)
