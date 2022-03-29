package com.example.recipeapp.viewModel

import androidx.lifecycle.*
import com.example.recipeapp.network.model.Recipe
import com.example.recipeapp.repository.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: RetroRepository): ViewModel() {
    lateinit var liveDataList: MutableLiveData<List<Recipe>>
    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<Recipe>>{
        return liveDataList
    }

    fun loadListOfData() {
        repository.searchRecipesApiCall("burger", liveDataList)
    }
}