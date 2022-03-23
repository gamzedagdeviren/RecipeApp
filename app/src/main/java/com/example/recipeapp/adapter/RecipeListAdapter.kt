package com.example.recipeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipeapp.R
import com.example.recipeapp.network.model.Location
import com.example.recipeapp.network.model.Recipe
import com.example.recipeapp.network.model.Results
import kotlinx.android.synthetic.main.search_recipe_item.view.*

class RecipeListAdapter : RecyclerView.Adapter<RecipeListAdapter.MyViewHolder>(){

    private var listData: List<Recipe>? = null

    fun setListData(listData: List<Recipe>?) {
        this.listData = listData
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeListAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_recipe_item, parent, false)
        return  MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeListAdapter.MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if(listData == null) return 0
        return listData?.size!!
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        //val imageFood = view.imageFood
        val txtRecipeName = view.txtRecipeName

        fun bind(data: Recipe) {
            txtRecipeName.text = data.title
            /*Glide.with(imageFood)
                .load(data.image)
                .into(imageFood)*/
        }
    }

}