package com.example.marvieapp

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marvieapp.databinding.LayoutCategoryItemBinding


class CategoryAdapter : ListAdapter<CategoryType, CategoryAdapter.MyViewHolder>(MyDiffUtil()) {

    private var callBack: CallBack? = null
    private var activeCategory: CategoryType = CategoryType.ALL


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutCategoryItemBinding.inflate(
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

    fun setCallBack(callBack: CallBack) {
        this.callBack = callBack
    }


    inner class MyViewHolder(
        private val binding: LayoutCategoryItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val backgroundShape: GradientDrawable =
            ContextCompat.getDrawable(
                itemView.context,
                R.drawable.shape_category
            ) as GradientDrawable

        fun bind(item: CategoryType) {

            binding.categoryTitleText.text = item.title
            if (item.icon != null) {
                binding.iconImage.setImageResource(item.icon)
                binding.iconImage.visibility = View.VISIBLE
            } else {
                binding.iconImage.visibility = View.GONE
            }

            if (activeCategory == item) {
                binding.root.background = (backgroundShape
                    .mutate() as GradientDrawable).apply {
                    setColor(Color.parseColor("#3ED598"))
                }
                binding.categoryTitleText.setTextColor(Color.parseColor("#ffffff"))
            } else {
                binding.root.background = (backgroundShape
                    .mutate() as GradientDrawable).apply {
                    setColor(Color.parseColor("#30444E"))
                }
                binding.categoryTitleText.setTextColor(Color.parseColor("#96A7AF"))

            }

            binding.root.setOnClickListener {
                callBack?.onCategoryClick(item)
                activeCategory = item
                notifyDataSetChanged()

            }

        }
    }

    interface CallBack {
        fun onCategoryClick(category: CategoryType)
    }
}
