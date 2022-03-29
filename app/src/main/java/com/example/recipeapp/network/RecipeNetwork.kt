package com.example.recipeapp.network

import com.example.recipeapp.Constant.Companion.API_KEY
import com.example.recipeapp.network.model.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RecipeNetwork {
    @GET("complexSearch")
    fun getSearchRecipes(@Query("apiKey") key: String,
                         @Query("query") searchString: String) : Call<RecipeList>

    @GET("{id}/information")
    fun getRecipe(@Path("id") id : Int,
                  @Query("apiKey") key: String) : Call<Recipe>


    @GET("search?")
    fun getLocation(@Query("query") searchString: String) : Call<List<Location>>
}