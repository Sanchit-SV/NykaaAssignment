package com.example.nykaaassignment


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