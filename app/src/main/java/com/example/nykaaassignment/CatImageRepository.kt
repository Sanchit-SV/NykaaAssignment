package com.example.nykaaassignment

import com.example.nykaaassignment.retrofit.CatImageService
import retrofit2.Response

class CatImageRepository (
    val catImageService: CatImageService
) {


    suspend fun getImages() : Response<ArrayList<CatImageResponse>>{

        val response = catImageService.getCatImages()
        return response
    }



}