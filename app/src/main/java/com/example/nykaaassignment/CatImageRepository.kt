package com.example.nykaaassignment

import retrofit2.Response

class CatImageRepository (
    val catImageService: CatImageService
) {


    suspend fun getImages() : Response<ArrayList<CatImageResponse>>{

        return catImageService.getCatImages()
    }



}