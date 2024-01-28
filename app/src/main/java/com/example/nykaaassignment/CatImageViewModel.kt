package com.example.nykaaassignment

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CatImageViewModel (
    private val catImageRepository: CatImageRepository
) : ViewModel() {


    var catImageDataState = MutableLiveData<CatResponseState<ArrayList<CatImageResponse>>>()

    fun getCatImages() {

        catImageDataState.postValue( CatResponseState.Loading)

        viewModelScope.launch {
            val catImagesRes = catImageRepository.getImages()

            catImagesRes.apply {
                if(isSuccessful && body()?.isNotEmpty() == true) {
                    catImageDataState.postValue(CatResponseState.Success(body()!!))
                } else {
                    catImageDataState.postValue(CatResponseState.Error(errorBody()?.string()?:message()))
                }
            }

        }
    }
}