package com.newsapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("top-headlines")
    suspend fun getNews(
        @Query("source") source: String,
        @Query("apiKey") apiKey: String
    ): Response<ResponseModel>
}