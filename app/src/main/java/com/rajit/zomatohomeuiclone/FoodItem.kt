package com.rajit.zomatohomeuiclone

data class FoodItem(
    val name: String,
    val price: Int,
    val imgDrawable: Int,
    val isPromoted: Boolean,
    val cuisine: List<String>,
    val deliveryTime: Int,
    val rating: Float
)
