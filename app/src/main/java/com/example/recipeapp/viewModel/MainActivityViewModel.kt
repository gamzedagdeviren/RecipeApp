package com.example.recipeapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipeapp.network.RecipeNetwork
import com.example.recipeapp.network.model.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class MainActivityViewModel: ViewModel() {
    lateinit var liveDataList: MutableLiveData<Recipe>
    /*init {
        liveDataList = MutableLiveData()
    }*/

    fun getLiveDataObserver(): MutableLiveData<Recipe> {
        return liveDataList
    }

    fun loadListOfData() {

    }
}