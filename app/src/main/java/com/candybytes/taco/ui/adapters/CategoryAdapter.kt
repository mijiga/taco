package com.candybytes.taco.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.candybytes.taco.R
import com.candybytes.taco.api.ApiResponse
import com.candybytes.taco.databinding.ItemCategoryBinding
import com.candybytes.taco.ui.fragments.CategoryFragment
import com.candybytes.taco.ui.fragments.CategoryListFragmentDirections
import com.candybytes.taco.vo.Category


class CategoryAdapter : ListAdapter<Category, CategoryAdapter.CategoryViewHolder> (Companion) {

    class CategoryViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    companion object: DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean = oldItem === newItem
        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean = oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryBinding.inflate(layoutInflater)

        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentCategory = getItem(position)

        holder.binding.category = currentCategory
        holder.binding.root.setOnClickListener {
            it.findNavController().navigate(R.id.action_categoriesFragment_to_categoryFragment)
        }
        holder.binding.executePendingBindings()
    }
}