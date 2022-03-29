package com.example.recipeapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recipeapp.Constant.Companion.API_KEY
import com.example.recipeapp.network.RecipeNetwork
import com.example.recipeapp.network.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetroRepository @Inject constructor(private val retroInstance: RecipeNetwork) {

    fun searchRecipesApiCall(query: String, liveDataList: MutableLiveData<List<Recipe>>) {
        val call: Call<RecipeList> = retroInstance.getSearchRecipes("08ee9d25ada745e2a41a6a85ef3e7c87", query)
        call.enqueue(object : Callback<RecipeList>{
            override fun onFailure(call: Call<RecipeList>, t: Throwable) {
                //Log.i("deneme repo fail", t.message.toString())
                liveDataList.postValue(null)
            }

            override fun onResponse(call: Call<RecipeList>, response: Response<RecipeList>) {
                if(response.isSuccessful) {
                    liveDataList.postValue(response.body()?.results!!)
                }
               // Log.i("deneme repo response", response.body()?.results?.get(0).toString())
                //Log.i("deneme repo code", response.code().toString())

            }
        })
    }
}