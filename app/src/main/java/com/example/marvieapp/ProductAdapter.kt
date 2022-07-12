package com.example.marvieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marvieapp.databinding.LayoutCategoryItemBinding
import com.example.marvieapp.databinding.LayoutProductItemBinding


class ProductAdapter : ListAdapter<Product, ProductAdapter.MyViewHolder>(MyDiffUtil<Product>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutProductItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class MyViewHolder(
        private val binding: LayoutProductItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Product) {
            binding.productImageImage.setImageResource(item.image)
            binding.titleText.text = item.title
            binding.priceText.text = "$${item.price}"
        }
    }

}
