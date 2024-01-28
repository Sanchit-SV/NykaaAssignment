package com.example.nykaaassignment.modules

import com.example.nykaaassignment.CatImageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        CatImageViewModel(get())
    }
}