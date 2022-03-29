package com.example.recipeapp.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipeapp.R
import com.example.recipeapp.network.model.Recipe
import com.example.recipeapp.view.DetailsActivity
import kotlinx.android.synthetic.main.search_recipe_item.view.*

class RecipeListAdapter : RecyclerView.Adapter<RecipeListAdapter.MyViewHolder>(){

    private var listData: List<Recipe>? = null
    lateinit var context: Context

    fun setListData(listData: List<Recipe>?) {
        this.listData = listData
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeListAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_recipe_item, parent, false)
        context = parent.context
        return  MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeListAdapter.MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
        holder.linearRecipeList.setOnClickListener{
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("recipe_id", listData?.get(position)?.id.toString())
            Log.i("deneme adapter id: ", listData?.get(position)?.id.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        if(listData == null) return 0
        return listData?.size!!
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageFood = view.imageFood
        val txtRecipeName = view.txtRecipeName
        val linearRecipeList = view.linearRecipeList

        fun bind(data: Recipe) {
            txtRecipeName.text = data.title
            Glide.with(imageFood)
                .load(data.image)
                .into(imageFood)
        }
    }

}