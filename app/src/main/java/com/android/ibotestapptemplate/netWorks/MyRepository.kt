package com.android.ibotestapptemplate.netWorks

import com.android.ibotestapptemplate.model.MovieListResponse
import com.android.ibotestapptemplate.model.MovieResponse
import javax.inject.Inject

class MyRepository @Inject constructor( private val apiService: ApiService) {


    suspend fun getMovieDetails(): List<MovieResponse>? {
        return apiService.getMovieResponse().body()
    }

}