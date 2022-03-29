package com.example.recipeapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.recipeapp.network.RecipeNetwork
import com.example.recipeapp.network.model.Recipe
import com.example.recipeapp.network.model.RecipeList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DetailsActivityRepository @Inject constructor(private val networkInstance: RecipeNetwork) {

    fun getRecipeApiCall(id: Int, liveDataList: MutableLiveData<Recipe>) {
        val call: Call<Recipe> = networkInstance.getRecipe(id, "08ee9d25ada745e2a41a6a85ef3e7c87")
        call.enqueue(object : Callback<Recipe> {
            override fun onFailure(call: Call<Recipe>, t: Throwable) {
                Log.i("deneme repo fail", t.message.toString())
                liveDataList.postValue(null)
            }

            override fun onResponse(call: Call<Recipe>, response: Response<Recipe>) {
                if(response.isSuccessful) {
                    liveDataList.postValue(response.body())
                }
                Log.i("deneme repo response", response.body().toString())
                Log.i("deneme repo code", response.code().toString())

            }
        })
    }

}