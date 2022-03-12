package com.example.recipeapp.network

import com.example.recipeapp.network.model.Recipe
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeNetwork {
    @GET("search?")
    fun getSearchRecipes(@Query("query") searchString: String) : Call<List<Recipe>>

    @GET("recipes/{id}/information?")
    fun getRecipe(@Path("id") id : Int) : Call<Recipe>
}