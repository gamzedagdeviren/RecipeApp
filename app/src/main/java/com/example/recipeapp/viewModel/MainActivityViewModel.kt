package com.example.recipeapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class MainActivityViewModel: ViewModel() {
    lateinit var liveDataList: MutableLiveData<>
    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<> {
        return liveDataList
    }

    fun loadListOfData() {

    }
}