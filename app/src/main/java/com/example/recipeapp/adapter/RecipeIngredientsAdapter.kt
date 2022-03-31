package com.example.recipeapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.R
import com.example.recipeapp.network.model.ExtendedIngredient
import kotlinx.android.synthetic.main.detail_recipe_ingredients_item.view.*

class RecipeIngredientsAdapter : RecyclerView.Adapter<RecipeIngredientsAdapter.MyViewHolder>(){

    private var listData: List<ExtendedIngredient> = ArrayList()
    lateinit var context: Context

    fun setListData(listData: List<ExtendedIngredient>) {
        this.listData = listData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeIngredientsAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.detail_recipe_ingredients_item, parent, false)
        context = parent.context
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeIngredientsAdapter.MyViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val txtIngredientsItem = view.txt_ingredients_item

        fun bind(data: ExtendedIngredient) {
            txtIngredientsItem.text = data.original
        }
    }
}