package com.candybytes.taco.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.candybytes.taco.R
import com.candybytes.taco.databinding.FragmentSearchFoodBinding
import com.candybytes.taco.ui.MainActivity
import com.candybytes.taco.ui.adapters.FoodAdapter
import com.candybytes.taco.ui.vm.SearchFoodViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFoodFragment : Fragment() {

    private val viewModel: SearchFoodViewModel by viewModels()

    private lateinit var binding: FragmentSearchFoodBinding;

    private val args : SearchFoodFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =  FragmentSearchFoodBinding.inflate(layoutInflater, container, false).apply {
            viewModel = this@SearchFoodFragment.viewModel
            lifecycleOwner = this@SearchFoodFragment
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val foodAdapter = FoodAdapter()
        val category = args.category

        binding.recyclerView.adapter = foodAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context, VERTICAL, false)

        /**
         * if category passed in safeArgs is null then fetch get all info from Room
         */
        if(category != null){
            viewModel.getByCategory(category.id ).observe(viewLifecycleOwner, {
                it.let { foodAdapter.submitList(it) }
            })
            (requireActivity() as MainActivity).title = category.name
        }else{
            viewModel.info.observe(viewLifecycleOwner, {
                it.let { foodAdapter.submitList(it) }
            })
            (requireActivity() as MainActivity).title = context?.getString(R.string.menu_search) ?: "Search"
        }
    }

}
