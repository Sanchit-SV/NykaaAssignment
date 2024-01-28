package com.example.nykaaassignment

import com.google.gson.annotations.SerializedName

data class CatImageResponse(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("width")
    val width: Int = 0,
    @SerializedName("height")
    val height: Int = 0,

)