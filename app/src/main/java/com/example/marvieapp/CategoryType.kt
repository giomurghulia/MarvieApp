package com.example.marvieapp

import androidx.annotation.DrawableRes

enum class CategoryType(
    val title: String,
    @DrawableRes val icon: Int? = null
) {
    ALL("ALL"),
    PARTY("Party", R.drawable.ic_party_category),
    CAMPING("Camping", R.drawable.ic_camping_category),
    CATEGORY1("Category1", R.drawable.ic_camping_category),
    CATEGORY2("Category2", R.drawable.ic_party_category),
    CATEGORY3("Category3", R.drawable.ic_camping_category)
}