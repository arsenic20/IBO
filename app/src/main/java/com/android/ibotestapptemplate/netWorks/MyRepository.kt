package com.android.ibotestapptemplate.netWorks

import com.android.ibotestapptemplate.model.MovieListResponse
import javax.inject.Inject

class MyRepository @Inject constructor( private val apiService: ApiService) {


    suspend fun getMovieDetails(): MovieListResponse? {
        return apiService.getMovieResponse().body()
    }

}