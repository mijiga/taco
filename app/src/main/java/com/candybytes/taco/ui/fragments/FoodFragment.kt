package com.candybytes.taco.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.candybytes.taco.R
import com.candybytes.taco.databinding.FragmentFoodBinding
import com.candybytes.taco.ui.MainActivity
import com.candybytes.taco.ui.vm.CategoriesViewModel
import com.candybytes.taco.vo.Food
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodFragment : Fragment() {

    val args: FoodFragmentArgs by navArgs()

    private lateinit var binding: FragmentFoodBinding

    private val viewModel: CategoriesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodBinding.inflate(layoutInflater, container, false).apply {
            food = args.food
        }
        binding.lifecycleOwner = viewLifecycleOwner
        return inflater.inflate(R.layout.fragment_food, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val food = args.food

        if(food != null){
            viewModel.getCategory(food.categoryId).observe(viewLifecycleOwner, {
                binding.textView.text = it.name
                binding.categoryButton.setOnClickListener{ view ->
                    val action = FoodFragmentDirections.actionFoodFragmentToSearchFoodFragment(it)
                    view.findNavController().navigate(action)
                }

                binding.notifyChange()
            })
        }

    }

    fun updateUI(food: Food){

    }


}