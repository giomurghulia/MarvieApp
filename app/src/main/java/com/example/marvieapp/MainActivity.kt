package com.example.marvieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val categoryAdapter = CategoryAdapter()
    private val productAdapter = ProductAdapter()


    private val categoryList = mutableListOf<CategoryType>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        handleWindowInset()

        binding.categoryRecycleView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.categoryRecycleView.adapter = categoryAdapter

        binding.productRecycleView.layoutManager = GridLayoutManager(this, 2)
        binding.productRecycleView.adapter = productAdapter


        updateAdapter()
        categoryAdapter.setCallBack(object : CategoryAdapter.CallBack {
            override fun onCategoryClick(category: CategoryType) {
                updateAdapter(category)
            }
        })
    }


    private fun handleWindowInset() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())

            binding.root.updatePadding(bottom = insets.bottom)

            windowInsets

        }
    }

    private fun updateAdapter(category: CategoryType? = CategoryType.ALL) {
        val products = when (category) {
            null, CategoryType.ALL -> PRODUCTS
            else -> {
                PRODUCTS.filter { it.categoryType == category }
            }
        }

        categoryAdapter.submitList(CategoryType.values().toList())
        productAdapter.submitList(products)
    }
}


val PRODUCTS = listOf(
    Product("Belt suit blazer", 160, R.drawable.ic_product1, CategoryType.CAMPING),
    Product("Belt suit blazer", 100, R.drawable.ic_product2, CategoryType.PARTY),
    Product("Belt suit", 10, R.drawable.ic_product3, CategoryType.CATEGORY1),
    Product("Belt suit blazer", 450, R.drawable.ic_product4, CategoryType.CATEGORY2),
    Product("Belt suit blazer", 550, R.drawable.ic_product1, CategoryType.CATEGORY3),
    Product("Belt suit", 550, R.drawable.ic_product2, CategoryType.CATEGORY1),
    Product("Belt suit blazer", 150, R.drawable.ic_product3, CategoryType.CATEGORY2),
    Product("Belt suit blazer", 150, R.drawable.ic_product4, CategoryType.CATEGORY3),
    Product("Belt suit blazer", 150, R.drawable.ic_product1, CategoryType.CATEGORY3),
    Product("Belt suit", 150, R.drawable.ic_product2, CategoryType.PARTY),
    Product("Belt suit blazer", 150, R.drawable.ic_product3, CategoryType.CATEGORY1),
    Product("Belt suit blazer", 150, R.drawable.ic_product4, CategoryType.CATEGORY2),
    Product("Belt suit blazer", 150, R.drawable.ic_product1, CategoryType.CATEGORY3),
    Product("Belt suit", 150, R.drawable.ic_product2, CategoryType.CATEGORY1),
    Product("Belt suit blazer", 150, R.drawable.ic_product3, CategoryType.CATEGORY2),
    Product("Belt suit blazer", 150, R.drawable.ic_product4, CategoryType.CATEGORY3),
    Product("Belt suit blazer", 150, R.drawable.ic_product1, CategoryType.CATEGORY2),
    Product("Belt suit", 150, R.drawable.ic_product2, CategoryType.PARTY),
    Product("Belt suit blazer", 150, R.drawable.ic_product3, CategoryType.CATEGORY1),
    Product("Belt suit blazer", 150, R.drawable.ic_product4, CategoryType.CATEGORY2),
    Product("Belt suit blazer", 150, R.drawable.ic_product1, CategoryType.CATEGORY3),
    Product("Belt suit blazer", 150, R.drawable.ic_product2, CategoryType.CATEGORY1),
    Product("Belt suit", 150, R.drawable.ic_product3, CategoryType.CATEGORY2),
    Product("Belt suit blazer", 150, R.drawable.ic_product4, CategoryType.CATEGORY3),
    Product("Belt suit blazer", 150, R.drawable.ic_product1, CategoryType.CATEGORY2),
    Product("Belt suit blazer", 150, R.drawable.ic_product2, CategoryType.PARTY),
    Product("Belt suit", 150, R.drawable.ic_product3, CategoryType.CATEGORY1),
    Product("Belt suit blazer", 150, R.drawable.ic_product4, CategoryType.CATEGORY2),
    Product("Belt suit", 10, R.drawable.ic_product1, CategoryType.CATEGORY3),
    Product("Belt suit", 1500, R.drawable.ic_product2, CategoryType.CATEGORY1),
    Product("Belt suit blazer", 150, R.drawable.ic_product3, CategoryType.CATEGORY2),
    Product("Belt", 15, R.drawable.ic_product4, CategoryType.CATEGORY3),

    )
