package com.example.recipeapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipeapp.R
import com.example.recipeapp.adapter.RecipeListAdapter
import com.example.recipeapp.viewModel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var recipeListAdapter: RecipeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        rvRecipeSearch.layoutManager = LinearLayoutManager(this)
        recipeListAdapter = RecipeListAdapter()
        rvRecipeSearch.adapter = recipeListAdapter
    }

    private fun initViewModel() {
        val viewModel:MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if (it != null) {
                Log.i("deneme main", it.toString())
                recipeListAdapter.setListData(it)
                recipeListAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "error in getting data to mainActivity", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.loadListOfData()
    }
}