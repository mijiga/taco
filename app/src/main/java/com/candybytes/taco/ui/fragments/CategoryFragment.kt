package com.candybytes.taco.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.candybytes.taco.databinding.FragmentSearchFoodBinding
import com.candybytes.taco.ui.adapters.FoodAdapter
import com.candybytes.taco.ui.vm.SearchFoodViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : Fragment() {


    private val viewModel: SearchFoodViewModel by viewModels()


    private lateinit var binding: FragmentSearchFoodBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =  FragmentSearchFoodBinding.inflate(layoutInflater, container, false).apply {
            viewModel = this@CategoryFragment.viewModel
            lifecycleOwner = this@CategoryFragment
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val foodAdapter = FoodAdapter()

        binding.recyclerView.adapter = foodAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context, VERTICAL, false)


    }



}