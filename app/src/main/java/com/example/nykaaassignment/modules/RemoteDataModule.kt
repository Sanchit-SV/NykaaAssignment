package com.example.nykaaassignment.modules


import com.example.nykaaassignment.CatImageRepository
import com.example.nykaaassignment.retrofit.CatImageService
import com.example.nykaaassignment.retrofit.RetrofitFactory
import org.koin.dsl.module

val remoteDataModule = module {
    single {
        RetrofitFactory
    }


    single<CatImageService> {
        RetrofitFactory.getRetrofit("https://api.thecatapi.com/")
            .create(CatImageService::class.java)
    }

    single <CatImageRepository> {
        CatImageRepository(get())
    }

}