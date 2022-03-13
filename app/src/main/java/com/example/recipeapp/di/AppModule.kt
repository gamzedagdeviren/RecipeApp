package com.example.recipeapp.di

import com.example.recipeapp.network.RecipeNetwork
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    val baseURL = "https://api.spoonacular.com/recipes/"

    @Singleton
    @Provides
    fun getRetroServiceInterface(retrofit: Retrofit): RecipeNetwork {
        return retrofit.create(RecipeNetwork::class.java)
    }

    @Singleton
    @Provides
    fun getRetroInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}