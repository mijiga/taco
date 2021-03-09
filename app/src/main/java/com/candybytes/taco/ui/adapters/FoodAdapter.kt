package com.candybytes.taco.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.candybytes.taco.R
import com.candybytes.taco.databinding.ItemFoodBinding
import com.candybytes.taco.ui.fragments.CategoryFragment
import com.candybytes.taco.ui.fragments.CategoryFragmentDirections
import com.candybytes.taco.ui.fragments.CategoryListFragmentDirections
import com.candybytes.taco.ui.fragments.SearchFoodFragmentDirections
import com.candybytes.taco.vo.Food


class FoodAdapter : ListAdapter<Food, FoodAdapter.FoodViewHolder> (Companion) {

    class FoodViewHolder(val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root)

    companion object: DiffUtil.ItemCallback<Food>() {
        override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean = oldItem === newItem
        override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean = oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFoodBinding.inflate(layoutInflater)

        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val currentFood = getItem(position)

        Log.d("Food", currentFood.toString())

        holder.binding.food = currentFood
        holder.binding.root.setOnClickListener {

            val action = SearchFoodFragmentDirections.actionSearchFoodFragmentToFoodFragment(currentFood)
            it.findNavController().navigate(action)
        }
        holder.binding.executePendingBindings()
    }
}