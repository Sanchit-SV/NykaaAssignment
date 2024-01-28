package com.example.nykaaassignment

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CatImageService {
    @GET("v1/images/search?limit=10")
    suspend fun getCatImages(
    ) : Response<ArrayList<CatImageResponse>>
}