package com.example.nykaaassignment.retrofit

import com.example.nykaaassignment.CatImageResponse
import retrofit2.Response
import retrofit2.http.GET

interface CatImageService {
    @GET("v1/images/search?limit=10")
    suspend fun getCatImages(
    ) : Response<ArrayList<CatImageResponse>>
}