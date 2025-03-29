package com.android.ibotestapptemplate.netWorks

import com.android.ibotestapptemplate.model.MovieListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("wp-content/plugins/whats-on-netflix/json/alldocs.json?_=1700718031139")
    suspend fun getMovieResponse() : Response<MovieListResponse>

}