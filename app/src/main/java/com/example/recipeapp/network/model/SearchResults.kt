package com.example.recipeapp.network.model

data class SearchResult (
    var results : List<Results>
)

data class Results (
    var id : Int,
    var title : String,
    var image : String,
    var imageType : String
)
