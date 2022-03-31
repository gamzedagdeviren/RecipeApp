package com.example.recipeapp.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.recipeapp.R
import com.example.recipeapp.adapter.RecipeIngredientsAdapter
import com.example.recipeapp.adapter.RecipeListAdapter
import com.example.recipeapp.viewModel.DetailsActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.search_recipe_item.*

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private lateinit var viewModel: DetailsActivityViewModel
    lateinit var recipeIngListAdapter: RecipeIngredientsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val id = Integer.parseInt(intent.extras!!.getString("recipe_id"))

        Log.i("deneme id", id.toString())
        initViewModel(id)
        initIngredientsRecyclerView()
    }

    private fun initIngredientsRecyclerView() {
        rv_recipe_ingredients.layoutManager = LinearLayoutManager(this)
        recipeIngListAdapter = RecipeIngredientsAdapter()
        rv_recipe_ingredients.adapter = recipeIngListAdapter
    }

    private fun initViewModel(id: Int) {
        viewModel = ViewModelProvider(this).get(DetailsActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if (it != null) {
                Log.i("deneme details", it.toString())
                txt_detail_recipe_name.text = it.title
                txt_detail_min.text = it.readyInMinutes?.toString() + " Minutes"
                txt_detail_serving.text = it.servings?.toString() + " Servings"
                txt_detail_likes.text = it.aggregateLikes?.toString() + " Likes"

                recipeIngListAdapter.setListData(it.extendedIngredients!!)

                Glide.with(img_detail_recipe)
                    .load(it.image)
                    .into(img_detail_recipe)
            } else {
                Toast.makeText(this, "error in getting data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.loadListOfData(id)
    }
}