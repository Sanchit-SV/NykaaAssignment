package com.example.nykaaassignment

sealed class CatResponseState<out T : Any> {

    object Loading : CatResponseState<Nothing>()

    data class Success<T : Any>(
        val catImages: ArrayList<CatImageResponse>
    ) : CatResponseState<T>()

    data class Error(
        val errorDetails: String
    ) : CatResponseState<Nothing>()
}
