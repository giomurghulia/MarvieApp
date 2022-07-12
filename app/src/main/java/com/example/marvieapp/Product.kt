package com.example.marvieapp

import androidx.annotation.DrawableRes

data class Product(
    val title: String,
    val price: Int,
    @DrawableRes val image: Int,
    val categoryType: CategoryType
)