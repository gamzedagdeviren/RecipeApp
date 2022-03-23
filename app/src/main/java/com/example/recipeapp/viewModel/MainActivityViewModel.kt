package com.example.recipeapp.viewModel

import android.util.Log
import androidx.lifecycle.*
import com.example.recipeapp.network.model.Location
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
        Log.i("deneme viewModel", liveDataList.toString())
        return liveDataList
    }

    fun loadListOfData() {
        repository.makeApiCall("falafel", liveDataList)
    }
}