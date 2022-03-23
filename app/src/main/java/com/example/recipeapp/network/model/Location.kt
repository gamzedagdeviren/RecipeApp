package com.example.recipeapp.network.model

data class Location(
    val latt_long: String?,
    val location_type: String?,
    val title: String?,
    val woeid: Int?
)
data class LocationList(
    val item: List<Location>
)