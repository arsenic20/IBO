package com.android.ibotestapptemplate.hilt

import com.android.ibotestapptemplate.netWorks.ApiService
import com.android.ibotestapptemplate.netWorks.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun getRetroFit():Retrofit{
         return Retrofit.Builder()
              .baseUrl("https://www.whats-on-netflix.com")
              .addConverterFactory(GsonConverterFactory.create())
              .build()
    }

    @Provides
    fun getApiService(retrofit: Retrofit): ApiService{
        return retrofit.create(ApiService::class.java)
    }


    @Provides
    fun getRespository(apiService: ApiService): MyRepository {
        return MyRepository(apiService)
    }




}