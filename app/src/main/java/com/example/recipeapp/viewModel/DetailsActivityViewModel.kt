package com.example.recipeapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipeapp.network.model.Recipe
import com.example.recipeapp.repository.DetailsActivityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsActivityViewModel @Inject constructor(private val repository: DetailsActivityRepository): ViewModel() {
    lateinit var liveDataList: MutableLiveData<Recipe>
    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<Recipe> {
        return liveDataList
    }

    fun loadListOfData(id: Int) {
        repository.getRecipeApiCall(id, liveDataList)
    }
}