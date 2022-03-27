package com.example.recipeapp.network.model

import com.google.gson.annotations.SerializedName

data class SearchResult (
    @SerializedName("results")
    val results: List<Results>
)

data class Results (
    @SerializedName("id")
    var id : Int,
    @SerializedName("title")
    var title : String,
    @SerializedName("image")
    var image : String,
    @SerializedName("imageType")
    var imageType : String
)
