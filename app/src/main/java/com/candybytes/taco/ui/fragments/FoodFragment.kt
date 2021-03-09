package com.candybytes.taco.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.candybytes.taco.R
import com.candybytes.taco.databinding.FragmentFoodBinding
import com.candybytes.taco.ui.MainActivity

class FoodFragment : Fragment() {

    val args: FoodFragmentArgs by navArgs()

    private lateinit var binding: FragmentFoodBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodBinding.inflate(layoutInflater, container, false).apply {
            food = args.food
        }
        return inflater.inflate(R.layout.fragment_food, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val food = args.food

        if(food != null){
            (activity as AppCompatActivity).supportActionBar?.title = food.description
        }

    }


}